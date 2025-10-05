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
        List employees = new LinkedList<Employee>();
        Random random = new Random();

        String[] firstNames = {"John", "Emma", "Aarav", "Sophia", "Liam", "Olivia", "Noah", "Isabella", "Ethan", "Mia", "Raj", "Priya", "Ananya", "Vikram", "Aditi"};
        String[] lastNames = {"Smith", "Johnson", "Patel", "Brown", "Williams", "Sharma", "Kumar", "Singh", "Davis", "Garcia"};
        String[] departments = {"Engineering", "HR", "Finance", "Sales", "Marketing", "IT Support", "Operations", "Research"};
        String[] jobTitles = {"Software Engineer", "Manager", "Analyst", "Director", "Consultant", "Team Lead", "Intern", "Specialist"};
        String[] businessUnits = {"Corporate", "Retail", "Technology", "Healthcare", "Education", "Finance"};
        String[] genders = {"Male", "Female", "Other"};
        String[] ethnicities = {"Asian", "White", "Black", "Hispanic", "Other"};
        String[] countries = {"USA", "India", "UK", "Canada", "Germany", "Australia"};
        String[] cities = {"New York", "Mumbai", "London", "Toronto", "Berlin", "Sydney", "Delhi", "Chicago", "San Francisco", "Bangalore"};

        for (int i = 1; i <= count; i++) {
            String name = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
            String empID = String.format("EMP%04d", i);
            String jobTitle = jobTitles[random.nextInt(jobTitles.length)];
            String department = departments[random.nextInt(departments.length)];
            String businessUnit = businessUnits[random.nextInt(businessUnits.length)];
            String gender = genders[random.nextInt(genders.length)];
            String ethnicity = ethnicities[random.nextInt(ethnicities.length)];
            int age = 22 + random.nextInt(40); // age between 22–61
            LocalDate hireDate = LocalDate.of(2005 + random.nextInt(20), 1 + random.nextInt(12), 1 + random.nextInt(28));
            long salary = 30000 + random.nextInt(120000); // between 30k – 150k
            String country = countries[random.nextInt(countries.length)];
            String city = cities[random.nextInt(cities.length)];

            employees.add(new Employee(name, empID, jobTitle, department, businessUnit, gender, ethnicity,
                    age, hireDate, salary, country, city));
        }
        //C:\Work\CJava\Amezon\AllEmployee.xlsx
       /* try(FileInputStream fileInputStream = new FileInputStream(new File("C:\\AaWork\\excel\\AllEmployee.xlsx"))){
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
        }*/

        return employees;
    }


}