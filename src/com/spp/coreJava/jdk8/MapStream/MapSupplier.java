package com.spp.coreJava.jdk8.MapStream;
import com.spp.coreJava.jdk8.excel.ALLEmployees;
import com.spp.coreJava.jdk8.excel.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSupplier{
    public Map<String, String> getStringToStringMap(){

        Map<String, String> myMap= new HashMap<String, String>();
        myMap.put("SAP123", "Jeevan Ram");
        myMap.put("SAP124", "Gyan Kumar");
        myMap.put("SAP125", "Ravi singh");
        myMap.put("SAP126", "Vimal Rao");
        myMap.put("SAP127", "Om Prakash Balmiky");
        return myMap;
    }
    public Map<String,Employee> getEmployeeHashMap(){
        Map allmapEmps = new HashMap<String, Employee>();

        List<Employee> allEmps= ALLEmployees.getALLEmployees();
        allEmps.stream().forEach(emp->allmapEmps.put(emp.getEmpID(), emp));

        return allmapEmps;
    }

    public Map<String,Employee> getEmployeeHashMapByStream(){
        System.out.println("......Inside getEmployeeHashMapByStream" );
        List<Employee> allEmps= ALLEmployees.getALLEmployees();
        //allEmps.stream().forEach(emp->allmapEmps.put(emp.getEmpID(), emp));
         // >>>> this will also work >>>>>>>
       // return allEmps.stream().collect(Collectors.toMap(emp-> emp.getEmpID(), emp-> emp));
        return allEmps.stream().collect(Collectors.toMap(Employee::getEmpID, emp-> emp));
    }






}
