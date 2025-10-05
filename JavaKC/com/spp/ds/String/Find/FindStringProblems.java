package com.spp.ds.String.Find;

import java.util.HashMap;
import java.util.Map;

public class FindStringProblems {

    /*****Find repeated character present first in a string*/
    public char getFirstRepeatedCharactor(String strArg){
        char ch=' ';
        char[] strArray = strArg.toCharArray();
        for(int i = 0; i< strArray.length; i++){
            char ch1= strArray[i];
              for(int j = i+1; j< strArray.length; j++){
                  if(ch1==strArray[j]){
                      ch=ch1;
                      return ch1;

                  }
              }
        }
        System.out.println("!!!   Sorry No Repetead character found");
        return ch;
    }

    public char getFirstRepeatedCharactorBYMAP(String strArg){
        char ch=' ';
        char[] strArray= strArg.toCharArray();
        Map<Character, Character> testMap = new HashMap();
        for(int i=0; i<strArray.length; i++){
            char ch1=strArray[i];
           if( testMap.put(ch1, ch1)!=null){
               System.out.println("The repested charact is :" + ch1);
               return ch1;
           }
        }
        System.out.println("!!!   Sorry No Repetead character found");
        return ch;
    }
}
