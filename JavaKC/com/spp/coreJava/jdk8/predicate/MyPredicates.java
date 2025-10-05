package com.spp.coreJava.jdk8.predicate;

import com.spp.coreJava.jdk8.excel.Employee;

import java.util.function.Predicate;

public class MyPredicates {

    public Predicate<Employee> AsianITMale= employee -> {
        return employee.getGender().equals("Male")&& employee.getEthnicity().equals("Asian") && employee.getJobTitle().equals("IT");
    };

    //public Predicate<Employee>



}
