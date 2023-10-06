package com.spp.coreJava.jdk8.mapfunction;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyMapFunctions {


     public  static int SquireGenerator(int num){
                 return num*num;
     }

    public static void main(String[] args) {

        List<Integer> allNums = Arrays.asList(2,3,4,5,6,7,8,9);

        List<Integer> allsquire = allNums.stream().map(num->SquireGenerator(num)).collect(Collectors.toList());
        allsquire.stream().forEach(System.out::println);
    }
}
