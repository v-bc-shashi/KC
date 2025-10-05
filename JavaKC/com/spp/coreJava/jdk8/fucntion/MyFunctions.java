package com.spp.coreJava.jdk8.fucntion;

import com.spp.coreJava.jdk8.excel.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyFunctions {

    static Function<List<Employee>,List<Employee>> engineeringManager= emplist->{
       return emplist.stream().filter(emp->emp.getJobTitle().equals("Manager")).collect(Collectors.toList());
    };
    static Function<List<Employee>, Map<String, List<Employee>>> employeeByEthnicity = employees-> employees.stream().collect(Collectors.groupingBy(Employee::getEthnicity));



}
