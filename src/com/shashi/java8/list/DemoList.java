package com.shashi.java8.list;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DemoList {
    public static void main(String[] args) {
        System.out.println("***********Demo OF List ******************");

        SampleEmployess  seObject = new SampleEmployess();
        List<Employee> allpersonList =seObject.getALLEmployees();
   /*     allpersonList.stream().forEach(
                employee -> System.out.println("Employee  :: " + employee));*/

        Map<String, Long > CitiwiseEmpCount = allpersonList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        //System.out.println(CitiwiseEmpCount);

        Set<String> allDepratments = allpersonList.stream().collect(Collectors.mapping(Employee::getDepartment, Collectors.toSet()));
        System.out.println(allDepratments);

    }
}
