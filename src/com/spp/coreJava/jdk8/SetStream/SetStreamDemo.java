package com.spp.coreJava.jdk8.SetStream;

import com.spp.coreJava.jdk8.excel.ALLEmployees;
import com.spp.coreJava.jdk8.excel.Employee;

import java.util.List;
import java.util.Set;

public class SetStreamDemo {

    public static void main(String[] args) {
        List<Employee> employeeList = ALLEmployees.getALLEmployees();
        Set<Employee> employeeSet= EmployeeSet.getEmployeeSet(employeeList);
       // System.out.println("Employee SET Size is:" + employeeSet.size());
        //System.out.println("Employee List Size is:" + employeeList.size());
        SerProcessor.processSet(employeeSet);

    }
}
