package com.spp.coreJava.jdk8.excel;

import java.util.List;

public class DemoList {
    public static void main(String[] args) {
        System.out.println("***********Demo OF List ******************");

        List<Employee> allpersonList = ALLEmployees.getALLEmployees();
        System.out.println(allpersonList.size());
        System.out.println(allpersonList);

    }
}
