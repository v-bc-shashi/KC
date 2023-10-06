package com.spp.coreJava.jdk8.SetStream;

import com.spp.coreJava.jdk8.excel.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SerProcessor {
    public static void processSet(Set<Employee> allEmpSet){
       Predicate<Employee> ChinaBijingEmployeeFilter = new Predicate<Employee>() {
           @Override
           public boolean test(Employee employee) {
               if (employee.getCountry().equals("China") && employee.getCity().equals("Beijing"))
                   return true;
               else
                   return false;
           }
       };

       List<Employee> ChinaBejingEmployess= allEmpSet.stream().filter(ChinaBijingEmployeeFilter).collect(Collectors.toList());
        System.out.println("Size of New List : "+ ChinaBejingEmployess.size());
        ChinaBejingEmployess.stream().forEach(System.out::println);
    } // End of MAIN Method
}//  End of class