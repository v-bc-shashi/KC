package com.spp.coreJava.jdk8.excel;

import java.time.LocalDate;

public class Employee {

private String empName;
private String empID;
private String JobTitle;
private String department;
private String businessUnit;
private String gender;
private String ethnicity;
private int empAge;
private LocalDate hireDate;
private long anualSalary;
private String country;
private String city;
    public Employee(){
        super();
    }
    public Employee(String empName, String empID, String jobTitle, String department, String businessUnit, String gender, String ethnicity, int empAge, LocalDate hireDate, long anualSalary, String country, String city) {
        this.empName = empName;
        this.empID = empID;
        JobTitle = jobTitle;
        this.department = department;
        this.businessUnit = businessUnit;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.empAge = empAge;
        this.hireDate = hireDate;
        this.anualSalary = anualSalary;
        this.country = country;
        this.city = city;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public long getAnualSalary() {
        return anualSalary;
    }

    public void setAnualSalary(long anualSalary) {
        this.anualSalary = anualSalary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empID='" + empID + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", department='" + department + '\'' +
                ", businessUnit='" + businessUnit + '\'' +
                ", gender='" + gender + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", empAge=" + empAge +
                ", hireDate=" + hireDate +
                ", anualSalary=" + anualSalary +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
