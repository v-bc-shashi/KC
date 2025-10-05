package com.spp.ds.array;

import java.util.ArrayList;
import java.util.List;

/* For a given unsorted Array and a number,
 find the SUB-Array of elements where
  sum of elements is equal to given number
  example given Array is [1,3,4,2 5,7,8,9] - and number is -12

  then the Result SubArray Should be - [3,4,5]= 12
*
* */
public class SubArrayOfGivenSUM {
    public List getSubArrayForSUM(int argArray[], int sum) {
        List<Integer> allNums = new ArrayList<>();
        int start = 0, end = 0;
        boolean isfound = false;
        for (int i = 0; i < argArray.length; i++) {
            start = i;
            int val = argArray[i];
            for (int j = i + 1; j < argArray.length; j++) {
                val = val + argArray[j];
                if (val == sum) {
                    end = j;
                    isfound = true;
                    break;
                }
             }
            if(isfound){
                break;
            }


        }
        if (isfound) {

            for (int i = start; i <= end; i++) {
                allNums.add(argArray[i]);
            }
        }else {
            System.out.println("Sorry SUM is Not Found");
        }

        return allNums;
    }
}
