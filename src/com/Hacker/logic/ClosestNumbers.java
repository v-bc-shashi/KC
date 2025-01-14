package com.Hacker.logic;

import java.util.Arrays;

/******************************PROBLEM *******
 Given an array of distinct integers, determine the minimum absolute difference between any two elements.
 Print all pairs of elements with that difference, ensuring the smaller number appears first in each pair, and the pairs are sorted in ascending order.
 Example:
 numbers = [6,2,4,10]
 -->The minimum absolute difference is 2 and
 ---> the pairs with that difference are (2,4) and (4,6).

 For - numbers = [4, 2, 1, 3]
 Sample Output 0
 1 2
 2 3
 3 4

 Hint 1->Do we really need to check all the pairs to get the minimum difference?
 Hint 2->Sort the array.
 ********/
public class ClosestNumbers {
    public static void main(String[] args) {
        System.out.println("*********** Out Put *************");

        // Java Stye of Array Declaration
        int[] numArray = {4, 2, 1, 3};

        Arrays.sort(numArray);
        System.out.println("***********After Sorting");

        // this is called Enhanced For loop
        for (int j : numArray) {
            System.out.println(j);
        }
        System.out.println("******Pair Printing");

        for(int i=1; i<numArray.length; i=i+2){
            System.out.println("( "+ numArray[i-1]+ " , "+  numArray[i] +" )");
        }

    }


}
