package com.sp.user.shared;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.data.util.Pair;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.InvalidNameException;
import java.util.*;
import java.util.regex.Pattern;

public class ExcelImporter {

    private final Set<Class<?>> NUMBER_REFLECTED_PRIMITIVE = Set.of(byte.class, short.class, int.class, long.class, float.class, double.class);
    private final Map<String, String> FILED_NAME_MAPPING =Map.of(
            "countryName", "countryId",
            "cityName", "cityId"

    ) ;

    private final Pattern ID_PREFIX_PATTERN= Pattern.compile("^\\s*(\\d+).*$");

    private final DataFormatter dataFormatter= new DataFormatter();

    public <T> List<T> generateEntityFromExcel(MultipartFile file, Class<T> clazz, List<Pair<String, String>> columns ){

        try{
            var workBook = new HSSFWorkbook(file.getInputStream());
            var formulaEvaluator= workBook.getCreationHelper().createFormulaEvaluator();
            formulaEvaluator.evaluateAll();

            var sheet = workBook.getSheetAt(0);
            var header=parseAndValidateHeader(sheet.getRow(0),columns );

            

        }catch(Exception ex){

        }
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

}
