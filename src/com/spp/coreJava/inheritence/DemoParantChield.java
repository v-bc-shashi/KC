package com.spp.coreJava.inheritence;

public class DemoParantChield {
    public static void main(String[] args) {
        // Parent class refrence can hold the object of child class.
        ClassP obj= new ClassCh();
        // But it child refrence can not hold the parent class reference.
       // ClassCh chobj= new ClassP();  // this is comile time error.
    }
}
