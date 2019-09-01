package com.spp.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Given an Array and key, find that any sum of two element is equal to key . array is sorted
public class SumInArray {

    // If Array is Sorted.
    public static boolean findSum(int arr[], int key) {

        if (arr.length == 0)
            return false;
        for (int i = 0, j = arr.length - 1; i < j; ) {

            if (arr[i] + arr[j] == key) {
                System.out.println("the Index for elements are- [" + i + " , " + j + " ]");
                return true;
            } else if (arr[i] + arr[j] < key) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

    // if Array is NOT Sorted.
    public static int[] getIndexOfSum(int arr[], int key){

        int result[]=new int[2];
        Map<Integer, Integer> lookUp = new HashMap<Integer, Integer>();

        for(int i=0;i<arr.length;i++){
            lookUp.put(arr[i], i);
        }

        for (int i=0;i<arr.length;i++) {

            if(lookUp.containsKey(Math.abs(key-arr[i]))){

                result[0] =i;
                result[1]= lookUp.get(Math.abs(key-arr[i]));
            }
        }

        return result;
    }



    public static void main(String[] args) {


        int arr[] = {40, 4, 5, 6, 7, 8, 9, 10, 11, 20, 3, 34, 32, 33};
        /*System.out.println(findSum()); // true
        System.out.println(findSum(arr, 41));// false;
        System.out.println(findSum(arr, 74));// true
        System.out.println(findSum(arr, 21)); // true
        System.out.println(findSum(arr, 11));// true*/
        System.out.println(findSum(arr, 74));// true
        int rs[] = getIndexOfSum(arr, 74);

        System.out.println("Result is - "+ rs[0] +" And "+ rs[1]);
    }
}
