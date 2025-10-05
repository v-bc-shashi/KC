package com.spp.coreJava.jdk8.MapStream;

import java.util.Map;

public class DemoMappingWithCharacterCount {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>output is >>>>>>>>>");

        String argStr ="aaaabbbbbccccdddddeeff";

       // String argStr ="this is working";
        MappingWithCharacterCount objMWCC = new MappingWithCharacterCount();
       // Map<String, Long> result= objMWCC.getCharCountPurejava8(argStr);

       // for(Map.Entry record:result.entrySet()){
         //  System.out.println("Chracter is :" + record.getKey() + " occured : "+ record.getValue());
       // }

        Map<Character, Long> result= objMWCC.getCharCountByListJava8(argStr);
        System.out.println("Result size is : "+result.size());

        for(Map.Entry record:result.entrySet()){
            System.out.println("Character is :" + record.getKey() + " occured : "+ record.getValue());
        }
    }
}
