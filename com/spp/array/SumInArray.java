package com.spp.array;

// Given an Array and key, find that any sum of two element is equal to key . array is sorted
public class SumInArray {

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

    public static void main(String[] args) {

        int arr[] = {3, 4, 5, 6, 7, 8, 9, 10, 11, 20, 30, 32, 34, 40};

        System.out.println(findSum(arr, 43)); // true
        System.out.println(findSum(arr, 41));// false;
        System.out.println(findSum(arr, 74));// true
        System.out.println(findSum(arr, 21)); // true
        System.out.println(findSum(arr, 11));// true

    }
}
