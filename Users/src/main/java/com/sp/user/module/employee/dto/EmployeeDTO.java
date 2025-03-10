package com.sp.user.module.employee.dto;


import com.sp.user.base.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO extends BaseDTO {

    private String employeeId;

    private String firstname;

    private String lastName;

    private String middleName;

    private LocalDate dateOfBirth;

    private LocalDate dateOfJoining;

    private String department;

    private String jobTitle;

    private String empLegalEntityCode;

    private String gender;

    private String countryName;

    private String emailId;

    private String contactNo;

    private String active;
}
