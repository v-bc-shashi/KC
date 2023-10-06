package com.spp.coreJava.jdk8.ListStream;

import com.spp.coreJava.jdk8.excel.ALLEmployees;
import com.spp.coreJava.jdk8.excel.Employee;

import java.util.LinkedList;
import java.util.List;

public class DemoMainList {
    public static void main(String[] args) {
        System.out.println("******* DemoMainList For List********");
        EmployeListPeocessor employeeProcessor = new EmployeListPeocessor();
        employeeProcessor.porocessData(ALLEmployees.getALLEmployees());

    }
}
