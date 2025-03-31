package com.sp.user.module.employee.utils;

import org.springframework.data.util.Pair;

import java.util.List;

public class ExcelGeneratorUtil {

    public static final List<Pair<String, String>> UPLOAD_Employee_COLUMNS = List.of(
            // Here 1sr will be Excel Column name and 2nd will Entity Variable name.
            Pair.of("EmployeeID", "employeeId"),
            Pair.of("First Name", "firstname"),
            Pair.of("Middle Name", "middleName"),
            Pair.of("Last Name", "lastName"),
            Pair.of("DOB", "dateOfBirth"),
            Pair.of("Date Of Joining", "dateOfJoining"),
            Pair.of("Department", "department"),
            Pair.of("Job Title", "jobTitle"),
            Pair.of("Gender", "gender"),
            Pair.of("Country Name", "countryName"),
            Pair.of("Email Id", "emailId"),
            Pair.of("Contact No", "contactNo"),
            Pair.of("Active", "active"),
            Pair.of("Employe LE Code", "empLegalEntityCode")


    );

    public static List<Pair<String, String>> getReportsColumnByEntityName(String entiryName){
        return null;
    }
}
