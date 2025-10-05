package com.spp.coreJava.jdk8.ListStream;

import com.spp.coreJava.jdk8.excel.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeListPeocessor {
   public  void porocessData(List<Employee> allEmpList) {

       System.out.println(">>>>>>>>>>out put is >>>>>>>.");

       Map<String, List<Employee>> countryWiseEmplyee = allEmpList.stream().collect(Collectors.groupingBy(Employee::getJobTitle));

      /* for(String key: countryWiseEmplyee.keySet()){
           System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
           System.out.println("Job Tile is :" + key);
           System.out.println("Number Employees are : "+ countryWiseEmplyee.get(key).size());
       }*/

       System.out.println(">>>>>>>>>>>>>>>>>>>this is All Vice presidents>>>>>>>>>>\n");
       List<Employee> VicePresidents= countryWiseEmplyee.get("Vice President");
       System.out.println("Size of new Map is : "+ VicePresidents.size());
       //VicePresidents.stream().forEach(emo);

       int totalEmployee = VicePresidents.size();
       System.out.println(">>>>>>>>>>>> TOTAL NUMBER OF EMMPLOYEE >>>>>>>>>>>>>> : ");
       System.out.println(totalEmployee);
       int sumofAllAages= VicePresidents.stream().collect(Collectors.summingInt(Employee::getEmpAge));
       System.out.println(">>>>>>>>>>>> SUM OF ALL AGES are EMMPLOYEE >>>>>>>>>>>>>> : ");
       System.out.println(sumofAllAages);
       double averageis= sumofAllAages/totalEmployee;
       System.out.println(">>>>>>>>>>>> CAlculated Avarage is : >>>>>>>>>>>>>> : ");
       System.out.println(averageis);
       double averageAgeOfEmployee =  VicePresidents.stream().collect(Collectors.averagingInt(Employee::getEmpAge));

       System.out.println(">>>>>>>>>>>> JAVA8 Avrage is  Avarage is : >>>>>>>>>>>>>> :");
       System.out.println(averageis);

       System.out.println("All Ages are : ");
       VicePresidents.stream().forEach(emp-> System.out.print( "  -  "+emp.getEmpAge()));
   }// END of Main method.
}// End of class