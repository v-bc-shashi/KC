package com.spp.coreJava.jdk8.MapStream;

import com.spp.coreJava.jdk8.excel.ALLEmployees;
import com.spp.coreJava.jdk8.excel.Employee;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {

        MapSupplier objSupply = new MapSupplier();
       // Map<String, Employee> allMapObjs = objSupply.getEmployeeHashMap();
        Map<String, Employee> allMapObjs = objSupply.getEmployeeHashMapByStream();

        MapProcesser objprocess = new MapProcesser();

        //objprocess.printMap(objprocess.getEmployeeHashMapByStreamForAllAsianITMaleEmployee());

        Map<String, List<Employee>>   allEmpGroupBy =objprocess.getGroupByEthinicity(ALLEmployees.getALLEmployees());

        for (String key : allEmpGroupBy.keySet()) {
            System.out.println("\nKey IS :" + key);
            System.out.println("Number of Employees Are :" + allEmpGroupBy.get(key).size());
            System.out.println("Number of Employees Are :" + allEmpGroupBy.get(key));
            System.out.println("\n.....................\n");
        }
    } // End of Main

}
