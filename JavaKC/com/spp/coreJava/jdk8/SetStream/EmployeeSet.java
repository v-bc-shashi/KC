package com.spp.coreJava.jdk8.SetStream;

import com.spp.coreJava.jdk8.excel.Employee;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeSet {
    public static Set<Employee> getEmployeeSet(List<Employee> employeeList){
        return employeeList.stream().collect(Collectors.toSet());
    }
}
