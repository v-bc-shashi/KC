package com.spp.coreJava.jdk8.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ALLEmployees {
    public static List<Employee> getALLEmployees() {
        List employeeList = new LinkedList<Employee>();
        //C:\Work\CJava\Amezon\AllEmployee.xlsx
        try(FileInputStream fileInputStream = new FileInputStream(new File("C:\\AaWork\\excel\\AllEmployee.xlsx"))){
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Employee employee=null;
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                employee = new Employee();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    //Check the cell type and format accordingly (cell.getCellType())
                    if (cell.getRowIndex()>0) {
                        switch (cell.getColumnIndex()) {
                            case 0:
                               // System.out.print(cell.getStringCellValue() + "t");
                                employee.setEmpID(new String(cell.getStringCellValue()));
                                break;
                            case 1:
                               // System.out.print(cell.getStringCellValue() + "t");
                                employee.setEmpName(new String(cell.getStringCellValue()));
                                break;
                            case 2:
                              //  System.out.print(cell.getStringCellValue() + "t");
                                employee.setJobTitle(new String(cell.getStringCellValue()));
                                break;
                            case 3:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setDepartment(new String(cell.getStringCellValue()));
                                break;
                            case 4:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setBusinessUnit(new String(cell.getStringCellValue()));
                                break;
                            case 5:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setGender(new String(cell.getStringCellValue()));
                                break;
                            case 6:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setEthnicity(new String(cell.getStringCellValue()));
                                break;
                            case 7:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setEmpAge((int) cell.getNumericCellValue());
                                break;
                            case 8:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setHireDate(cell.getLocalDateTimeCellValue().toLocalDate());
                                break;
                            case 9:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setAnualSalary((long) cell.getNumericCellValue());
                                break;
                            case 10:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setCountry(new String(cell.getStringCellValue()));
                                break;
                            case 11:
                                //System.out.print(cell.getStringCellValue() + "t");
                                employee.setCity(new String(cell.getStringCellValue()));
                                break;


                        }
                    }
                }
               // System.out.println(employee);
                if(employee.getEmpName()!=null && employee.getEmpID()!=null)
                employeeList.add(employee);
            }
            fileInputStream.close();
        } catch (FileNotFoundException fnfExcp) {
            throw new RuntimeException(fnfExcp);
        } catch (IOException ioExcp) {
            throw new RuntimeException(ioExcp);
        }

        return employeeList;
    }


}