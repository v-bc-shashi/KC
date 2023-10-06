package com.spp.ds.String.reverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface ReverseStr{
    public String reverit(String strArg);
}
public class ReverseString {

    public String reversMeByStingBuilder(String argString){
        StringBuffer sb = new StringBuffer(argString);
        System.out.println(sb.reverse());
        return sb.reverse().toString();
    }


    public String reverseMeBySimpleLogicOfArray(String argStr){
        char  charArr[]= argStr.toCharArray();
        for(int i=0, j= argStr.length()-1; i<j; i++, j-- ){
            char temp = charArr[i];
            charArr[i]= charArr[j];
            charArr[j]= temp;
        }
        String newstr= new String(charArr);
        System.out.println(newstr);
        return newstr;
    }

    public String reverseStingByLogicOfCancatinate(String strArg){
        String rvsStr = "";
        for(int i=0; i<strArg.length(); i++) {
            char cs = strArg.charAt(i);
            rvsStr= cs+rvsStr;
        }
        System.out.println("Original String is " + strArg);
        System.out.println("Reversed String is "+ rvsStr);
        return rvsStr;
    }


    public String reverStrngByLambdaWithBuilder(String strArg) {
        ReverseStr reverseStr = (strArge) -> {
            return new StringBuilder(strArge).reverse().toString();
        };
      return reverseStr.reverit(strArg);
    }


    public String reverStrngByLambdaWithCollection(String strArg) {

        char charArr[] = strArg.toCharArray();
         List mylist =Arrays.asList(charArr);
        System.out.println(mylist.get(0).toString());
        //  Collections.reverse(Arrays.asList(strArg.toCharArray()));

        return null;
    }

}
