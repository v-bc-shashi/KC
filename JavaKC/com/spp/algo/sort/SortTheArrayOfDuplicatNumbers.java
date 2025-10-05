package com.spp.algo.sort;

public class SortTheArrayOfDuplicatNumbers {

    public static int[] sortArrayByLogic(int nums[]){

        System.out.println("................In logic method ..............");
        for (int i=0; i<nums.length; i++){
            System.out.println();
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>Working for Sort Array>>>>>>>>>>>>>>");
        int arr[]={1,2,2,2,1,4,7,5,6,4,5,8,1,6,9};
        int[] result = sortArrayByLogic(arr);
    }

}
