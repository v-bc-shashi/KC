package com.spp.coreJava.jdk8.fucntion;

import com.spp.coreJava.jdk8.excel.ALLEmployees;
import com.spp.coreJava.jdk8.excel.Employee;

import java.util.List;
import java.util.Map;

public class functionDemo {
    public static void main(String[] args) {
        System.out.println("\n>>>>> functionDemo >>>>>>>\n");

        List<Employee> engEmps = MyFunctions.engineeringManager.apply(ALLEmployees.getALLEmployees());

        System.out.println(engEmps.size());
        //engEmps.stream().forEach(emp->System.out.println(emp.getEmpName() + "  : " + emp.getJobTitle()));


        // Emloyee by ethnicity
        Map<String, List<Employee>> allEmpsByEthencity = MyFunctions.employeeByEthnicity.apply(ALLEmployees.getALLEmployees());

        System.out.println("Size is :" + allEmpsByEthencity.size());

        allEmpsByEthencity.keySet().stream().forEach(key -> System.out.println("\n.................\nKey is :" + key + "\nEmployess are :\n"+ allEmpsByEthencity.get(key) +"\n------------\n"));

    }
}
