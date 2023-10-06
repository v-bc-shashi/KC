package com.spp.ds.numers;

public class DecimalToBinaryDemo {
    public static void main(String[] args) {
        System.out.println("\nThis is Main --");
        DecimalToBinary dtb= new DecimalToBinary();
        System.out.println(dtb.getBinarybyLogiWithString(140));
        System.out.println(dtb.getBinarybyLogiWithString(10));
        System.out.println("\n+++++++++++++++++++++\n");
        System.out.println(dtb.getBinaryByLogicWithIntArray(140));
        System.out.println(dtb.getBinaryByLogicWithIntArray(10));
        System.out.println("\n+++++++++++++++++++++\n");
        System.out.println(dtb.decimaltoBinarybyJava(140));
        System.out.println(dtb.decimaltoBinarybyJava(10));

        //10001100
        System.out.println("\nIts DONE");
    }
}

