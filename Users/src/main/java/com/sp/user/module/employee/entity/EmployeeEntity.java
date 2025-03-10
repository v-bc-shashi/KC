package com.sp.  user.module.employee.entity;

import com.sp.user.base.entity.BaseEntity;
import com.sp.user.module.employee.constants.EmployeeConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema= EmployeeConstants.SCHEMA_PUBLIC, name=EmployeeConstants.EMPLOYEE_TABLE_NAME)
public class EmployeeEntity extends BaseEntity {
    @Id
    @Column(name= EmployeeConstants.COLUMN_EMPLOYEE_ID)
    private String employeeId;
    @Column(name= EmployeeConstants.COLUMN_FIRST_NAME)
    private String firstname;
    @Column(name= EmployeeConstants.COLUMN_LAST_NAME)
    private String lastName;
    @Column(name= EmployeeConstants.COLUMN_MIDDLE_NAME)
    private String middleName;
    @Column(name= EmployeeConstants.COLUMN_DATE_OF_BIRTH)
    private LocalDate dateOfBirth;
    @Column(name= EmployeeConstants.COLUMN_JOINING_DATE)
    private LocalDate dateOfJoining;
    @Column(name= EmployeeConstants.COLUMN_DEPARTMENT)
    private String department;
    @Column(name= EmployeeConstants.COLUMN_JOB_TITLE)
    private String jobTitle;
    @Column(name= EmployeeConstants.COLUMN_EMP_LEGAL_CODE)
    private String empLegalEntityCode;
    @Column(name= EmployeeConstants.COLUMN_GENDER)
    private String gender;
    @Column(name= EmployeeConstants.COLUMN_COUNTRY_NAME)
    private String countryName;
    @Column(name= EmployeeConstants.COLUMN_EMP_EMAIL_ID)
    private String emailId;
    @Column(name= EmployeeConstants.COLUMN_EMP_CONTACT_NO)
    private String contactNo;
    @Column(name= EmployeeConstants.COLUMN_ACTIVE)
    private String active;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryKey{

        @Column(name= EmployeeConstants.COLUMN_EMPLOYEE_ID)
        private String employeeId;
        @Column(name= EmployeeConstants.COLUMN_EMP_EMAIL_ID)
        private String emailId;

    }

}
