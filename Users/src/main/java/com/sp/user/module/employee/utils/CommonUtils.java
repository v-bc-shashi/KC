package com.sp.user.module.employee.utils;

import com.sp.user.base.exception.UserServiceException;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.util.Pair;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class CommonUtils {

    public static <T> List<T> convertToEntity(MultipartFile file, Class<T> clazz, List<Pair<String, String>> columns) throws UserServiceException, IOException {
        var workbook =  new XSSFWorkbook(file.getInputStream());
     //   var workbook =  new  HSSFWorkbook(file.getInputStream());
        List<T> entities = new LinkedList<>();
        try {
            var sheet = workbook.getSheetAt(0);
            List<String> headers = new ArrayList<>();
            Iterator<Cell> iterator = sheet.getRow(0).cellIterator();
            while (iterator.hasNext()) {
                Cell cell = iterator.next();
                String columnName = null;
                for(Pair <String,String> pair : columns) {
                    if(pair.getFirst().equalsIgnoreCase(cell.getStringCellValue().trim())) {
                        columnName =  pair.getSecond();
                        break;
                    }
                }
                if(columnName != null)
                    headers.add(columnName);
                else if (cell != null && cell.getCellType() != CellType.BLANK){
                    throw new UserServiceException("Column Not available, Column Name :"+cell.getStringCellValue().trim()+" , Kindly check the file.");
                }
            }

            if(columns.size() != headers.size())
                throw new UserServiceException("Total Column count not matching, Kindly check the file.");
            for(Row row :sheet) {
                if(row.getRowNum() == 0) continue;
                   if(!isRowEmpty(row)) {
                    try {
                        T entity = clazz.newInstance();
                        T entityPK = null;
                        int cellNo = 0;
                        while (cellNo < headers.size()) {
                            var header = headers.get(cellNo);
                            fieldLoop:
                            for(Field field1: clazz.getDeclaredFields()) {
                                if(field1.getName().equalsIgnoreCase(header)) {
                                    generateEntityWithPK(row, entity, cellNo, field1);
                                    break fieldLoop;
                                } else if(field1.isAnnotationPresent(EmbeddedId.class)) {
                                    for(Field pkField: field1.getType().getDeclaredFields()) {
                                        if(pkField.getName().equalsIgnoreCase(header.toString())) {
                                            if(entityPK == null)
                                                entityPK = (T) field1.getType().newInstance();
                                            generateEntityWithPK(row, entityPK, cellNo, pkField);
                                            field1.setAccessible(true);
                                            field1.set(entity, entityPK);
                                            break fieldLoop;
                                        }
                                    }
                                }
                            }
                            cellNo++;
                        }
                        entities.add(entity);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new UserServiceException(e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            throw new UserServiceException(e.getMessage());
        } finally {
            workbook.close();
        }
        return entities;
    }
    public static LocalDate safeParseLocalDate(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }

        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate safeParseLocalDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }

        return LocalDate.parse(date);
    }

    private static void cleanupFilters(Map<String, String> filters) {
       /* Map<String, String> filterMap = new HashMap<String, String>(filters);
        Set<String> keys = filterMap.keySet();
        for (var key : keys) {
            if (nameDBFieldMapping.containsKey(key)) {
                var value = filters.remove(key);
                filters.put(nameDBFieldMapping.get(key), value);
            }
        }*/
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static boolean isRowEmpty(Row row) {
        boolean isEmpty = true;
        DataFormatter dataFormatter = new DataFormatter();

        if (row != null) {
            for (Cell cell : row) {
                if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
                    isEmpty = false;
                    break;
                }
            }
        }
        return isEmpty;
    }

    private static <T> void generateEntityWithPK(Row row, T entity, int cellNo, Field  field )
            throws UserServiceException {
        var cell = row.getCell(cellNo);
        Object cellValue = null;
        try {
            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        cellValue = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            cellValue = dateFormat.format(cell.getDateCellValue());
                        } else
                            cellValue = cell.getNumericCellValue();
                        break;
                    case BOOLEAN:
                        cellValue = cell.getBooleanCellValue();
                        break;
                    default:
                        break;
                }
                field.setAccessible(true);
                if ((field.isAnnotationPresent(Id.class) || (entity.getClass().isAnnotationPresent(Embeddable.class) )) && cellValue == null) {
                    throw new UserServiceException("Primary key column should not empty, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
                } else if (field.isAnnotationPresent(NotNull.class) && cellValue == null) {
                    throw new UserServiceException("Mandatory Column should not empty, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
                } else if (field.isAnnotationPresent(Size.class) && cellValue != null && field.getAnnotation(Size.class).max() < cellValue.toString().length()) {
                    throw new UserServiceException("Column Lenght should not exceed Max Length, ColumnName: "+ field.getName()+ ", Row Number : "+row.getRowNum() +", Cell Number : "+(cellNo+1)+", Max Size Is:"+field.getAnnotation(Size.class).max());
                } else if (field.isAnnotationPresent(Digits.class) && cellValue != null) {
                    int length = 0;
                    BigDecimal vall = BigDecimal.valueOf(Double.parseDouble(cellValue.toString()));
                    vall = vall.stripTrailingZeros();
                    length = vall.precision() - vall.scale();
                    if(field.getAnnotation(Digits.class).integer() < length)
                        throw new UserServiceException("Column Lenght should not exceed Max Length, ColumnName: "+ field.getName()+ ", Row Number : "+row.getRowNum() +", Cell Number : "+(cellNo+1)+", Max Size Is:"+field.getAnnotation(Digits.class).integer());
                    setField(entity, field, cellValue, cell);
                } else if (cellValue != null) {
                    setField(entity, field, cellValue, cell);
                }
            } else if ((field.isAnnotationPresent(Id.class) || entity.getClass().isAnnotationPresent(Embeddable.class)) && cellValue == null) {
                throw new UserServiceException("Primary key column should not empty, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
            } else if (field.isAnnotationPresent(NotNull.class) && cellValue == null) {
                throw new UserServiceException("Mandatory Column should not empty, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
            }
        } catch (DataIntegrityViolationException dive) {
            throw new UserServiceException("Kindly check the Data and proceed for Save, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
        } catch (IllegalArgumentException iae) {
            throw new UserServiceException("Unable to parse the column value, kindly update and proceed to save, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
        } catch (IllegalAccessException acc) {
            throw new UserServiceException("Unable to access the value, kindly update and proceed to save, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
        } catch (DateTimeParseException dateE) {
            throw new UserServiceException("Unable to parse the date value, kindly update and proceed to save, ColumnName: " + field.getName() + ", Row Number : " + row.getRowNum() + ",Cell Number : " + (cellNo + 1));
        }
    }
    public static final DataFormatter dataFormatter = new DataFormatter();

    private static <T> void setField(T entity, Field field, Object cellValue, Cell cell) throws IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        if (field.getType() == Integer.class) {
            if (cellValue instanceof String)
                field.set(entity, Integer.parseInt((String) cellValue));
            if (cellValue instanceof Double)
                field.set(entity, (Integer) ((Double) cellValue).intValue());
        } else if (field.getType() == Long.class) {
            if (cellValue instanceof Number)
                field.set(entity, ((Number) cellValue).longValue());
            else field.set(entity, Long.parseLong((String) cellValue));
        } else if (field.getType() == Float.class) {
            field.set(entity, Float.parseFloat((String) cellValue));
        } else if (field.getType() == Double.class) {
            if(cellValue instanceof Double)
                field.set(entity, cellValue);
            else
                field.set(entity, Double.parseDouble((String) cellValue));
        } else if (field.getType() == BigInteger.class) {
            if (cellValue instanceof String)
                field.set(entity, new BigInteger((String) cellValue));
            else
                field.set(entity, BigInteger.valueOf(((Double) cellValue).intValue()));
        } else if (field.getType() == BigDecimal.class) {
            BigDecimal ret = null;
            if (cellValue instanceof BigDecimal) {
                ret = ((BigDecimal) cellValue).setScale(3, RoundingMode.CEILING);
            } else if (cellValue instanceof String) {
                ret = new BigDecimal((String) cellValue).setScale(3, RoundingMode.CEILING);
            } else if (cellValue instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) cellValue).setScale(3, RoundingMode.CEILING);
            } else if (cellValue instanceof Number) {
                ret = new BigDecimal(((Number) cellValue).doubleValue()).setScale(3, RoundingMode.CEILING);
            }
            field.set(entity, ret);
        } else if (field.getType() == String.class) {
            if(cellValue instanceof String) {
                field.set(entity, cellValue);
            } else {
                field.set(entity, dataFormatter.formatCellValue(cell));
            }
        } else if (field.getType() == java.sql.Date.class) {
            field.set(entity, java.sql.Date.valueOf(LocalDate.parse(cellValue.toString())));
        } else if (field.getType() == LocalDateTime.class) {
            field.set(entity, (LocalDateTime) cellValue);
        } else if (field.getType() == LocalDate.class) {
            field.set(entity, LocalDate.parse(cellValue.toString()));
        } else if (field.getType() == RichTextString.class) {
            field.set(entity, (RichTextString) cellValue);
        } else if (field.getType() == Boolean.class) {
            if ("Y".equalsIgnoreCase((String) cellValue) || "T".equalsIgnoreCase((String) cellValue))
                field.set(entity, true);
            else field.set(entity, false);
        } else {
            field.set(entity, cellValue);
        }
    }



    public static String formatDate(Date payDate) {
        if(payDate == null) {
            return "";
        }
        return formatLocalDate(payDate.toLocalDate());
    }

    public static String formatLocalDate(LocalDate payDate) {
        return payDate == null ? null
                : CommonConstants.DEFAULT_DATE_FORMATTER.format(payDate);
    }

    public static String formatPrice(double rate) {
        var format = new DecimalFormat("#,###.00");
        return format.format(rate);
    }

    public static String stripIdPrefix(String activityName) {
        var comps = StringUtils.split(activityName, "-");
        return ArrayUtils.get(comps, 1, "").trim();
    }

    public static <T> T getLastItem(List<T> reservations) {
        return CollectionUtils.isNotEmpty(reservations) ? reservations.get(reservations.size() - 1) : null;
    }
}
