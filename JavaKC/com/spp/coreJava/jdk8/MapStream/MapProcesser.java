package com.spp.coreJava.jdk8.MapStream;

import com.spp.coreJava.jdk8.excel.ALLEmployees;
import com.spp.coreJava.jdk8.excel.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapProcesser {
    public void printMap(Map<String,Employee> printMap){
        for (Map.Entry<String, Employee> mapSet:printMap.entrySet()) {
            System.out.println("Key :"+mapSet.getKey() + " Value :"+ mapSet.getValue());
        }

        System.out.println("<>>>>>>>>>>>>Total Record Printed is : "+ printMap.size());
    }
 // Get all Employee as MAP where Employee is : Male , IT and Asian
    public Map<String,Employee> getEmployeeHashMapByStreamForAllAsianITMaleEmployee(){
        System.out.println("......Inside getEmployeeHashMapByStream" );
        List<Employee> allEmps= ALLEmployees.getALLEmployees();
        //allEmps.stream().forEach(emp->allmapEmps.put(emp.getEmpID(), emp));
        // >>>> this will also work >>>>>>>
        // return allEmps.stream().collect(Collectors.toMap(emp-> emp.getEmpID(), emp-> emp));
        return allEmps.stream().filter(empObj-> empObj.getEthnicity().equals("Asian") && empObj.getGender().equals("Male") &&  empObj.getDepartment().equals("IT")).collect(Collectors.toMap(Employee::getEmpID, emp-> emp));
    }

    // Example of GroupBy of MAP Collectors.
    public Map<String, List<Employee>> getGroupByEthinicity(List<Employee> allEmps){

        Map<String, List<Employee>>  allEmpGroupBy = allEmps.stream().collect(Collectors.groupingBy(Employee::getEthnicity ));
        return allEmpGroupBy;
    }


}
