package com.sp.user.module.employee.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

@Log4j2
@Component
public class ExcelImporter {

    private final Set<Class<?>> NUMBER_REFLECTED_PRIMITIVES = Set.of(byte.class, short.class, int.class, long.class, float.class, double.class);
    private final Map<String, String> FILED_NAME_MAPPING =Map.of(
            "countryName", "countryId",
            "cityName", "cityId"

    ) ;


    private final Pattern ID_PREFIX_PATTERN= Pattern.compile("^\\s*(\\d+).*$");

    private final DataFormatter dataFormatter= new DataFormatter();

    public <T> List<T> generateEntityFromExcel(MultipartFile file, Class<T> clazz, List<Pair<String, String>> columns ){
        List<T> entities = new ArrayList<>();
        try{
            var workBook = new HSSFWorkbook(file.getInputStream());
            var formulaEvaluator= workBook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateAll();
            var sheet = workBook.getSheetAt(0);
            var headers=parseAndValidateHeader(sheet.getRow(0),columns );


            var rowIterator = sheet.rowIterator();

            while (rowIterator.hasNext()) {
                var row = rowIterator.next();
                if (row.getRowNum() == 0 || isRowEmpty(row, formulaEvaluator)) {
                    continue;
                }

                T entity = clazz.getDeclaredConstructor().newInstance();
                int cellNo = 0;


                    while (cellNo < headers.size()) {
                        var header = headers.get(cellNo);
                        Field field = fetchField(clazz, header);
                        if (field != null) {
                            field.setAccessible(true);
                            var cell = row.getCell(cellNo);
                            var value = sanitizeFieldValue(field, cell, formulaEvaluator);
                            field.set(entity, value);
                        } else {
                            log.warn("Field not found for {}", header);
                        }
                        cellNo++;
                    }

                entities.add(entity);

              }

            return entities;
        }catch(Exception ex){
            ex.printStackTrace();
        }
       return entities;
    }


    private List<String >parseAndValidateHeader(Row headerRow, List<Pair<String, String>> columns){

        List<String> headers = new ArrayList<>();
        Iterator<Cell> cellIterator = headerRow.cellIterator();
        while(cellIterator.hasNext()){
            Cell cell= cellIterator.next();
            String columnName= null;

            for(Pair<String, String> pair:columns){
                if(pair.getSecond().equalsIgnoreCase(cell.getStringCellValue().trim())){
                    columnName= pair.getFirst();
                    break;
                }
            }
            if(columnName!=null){
                headers.add(columnName);
            }else if(cell !=null && cell.getCellType() != CellType.BLANK){
                throw new InvalidInputException("Column Not Available , Column Name: '"+ cell.getStringCellValue().trim()
                        + "' Kindly check  tje file. "
                        );
            }
        }

        return headers;
    }

    private boolean isRowEmpty(Row row, FormulaEvaluator formulaEvaluator) {
        boolean isEmpty = true;
        DataFormatter dataFormatter = new DataFormatter();

        if (row != null) {
            for (Cell cell : row) {
                if (!dataFormatter.formatCellValue(cell, formulaEvaluator).trim().isEmpty()) {
                    isEmpty = false;
                    break;
                }
            }
        }
        return isEmpty;
    }


    private Field fetchField(Class<?> clazz, String fieldName) {
        var field = safeFieldGet(clazz, fieldName);
        if (field != null && !field.isAnnotationPresent(Formula.class)) {
            return field;
        }


        if (fieldName.toLowerCase().endsWith("name")) {
            var alternateFieldName = fieldName.substring(0, fieldName.length() - 4);
            field = safeFieldGet(clazz, alternateFieldName);
            if (field != null) {
                return field;
            }

            field = safeFieldGet(clazz, alternateFieldName + "Code");
            if (field != null) {
                return field;
            }

            field = safeFieldGet(clazz, alternateFieldName + "Id");
            return field;
        }

        return null;
    }
    private Field safeFieldGet(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            try {
                return clazz.getSuperclass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException ex) {
                return null;
            }
        }
    }



    private Object sanitizeFieldValue(Field field, Cell cell, FormulaEvaluator formulaEvaluator) {
        String strValue = this.dataFormatter.formatCellValue(cell, formulaEvaluator);
        if (cell == null || strValue == null) {
            return null;
        }

        if (cell.getCellType() == CellType.FORMULA) {
            System.out.println("Formula is " + cell.getCellFormula());
            switch (cell.getCachedFormulaResultType()) {
                case NUMERIC:
                    System.out.println("Last evaluated as: " + cell.getNumericCellValue());
                    break;
                case STRING:
                    System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
                    break;
            }
        }

          if (Enum.class.isAssignableFrom(field.getType())) {
            //noinspection unchecked
            var enumType = (Class<Enum>) field.getType();
            //noinspection unchecked
            return Enum.valueOf(enumType, strValue);
        }

        if (LocalDate.class.isAssignableFrom(field.getType())) {
            if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return LocalDate.parse(dateFormat.format(cell.getDateCellValue()));
            }
            return LocalDate.parse(strValue);
        }

//        if (FIELD_REVERSE_LOOKUP_DIR.containsKey(field.getName())) {
//            var matcher = ID_PREFIX_PATTERN.matcher(strValue);
//            if (matcher.find()) {
//                strValue = matcher.group(1);
//            } else if (StringUtils.isNotBlank(legalEntityCode)) {
//                var key = String.join(CommonConstant.KEY_DELIMITER, field.getName(), legalEntityCode, strValue);
//                strValue = String.valueOf(REVERSE_LOOKUP_CACHE.get(key));
//            }
//        }


        if (Number.class.isAssignableFrom(field.getType()) || NUMBER_REFLECTED_PRIMITIVES.contains(field.getType())) {
            if (StringUtils.isBlank(strValue)) {
                return null;
            }
            if (Double.class.isAssignableFrom(field.getType())) {
                return Double.parseDouble(strValue);
            } else if (Float.class.isAssignableFrom(field.getType())) {
                return Float.parseFloat(strValue);
            } else if (Long.class.isAssignableFrom(field.getType())) {
                return Long.parseLong(strValue);
            } else if (Integer.class.isAssignableFrom(field.getType())) {
                return Integer.parseInt(strValue);
            }
        }

        return strValue;
    }
}
