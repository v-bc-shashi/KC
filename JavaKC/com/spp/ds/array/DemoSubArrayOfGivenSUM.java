package com.spp.ds.array;

import com.spp.ds.array.SubArrayOfGivenSUM;

import java.util.List;

public class DemoSubArrayOfGivenSUM {

    public static void main(String[] args) {
        System.out.println("**************out put is **************");
        SubArrayOfGivenSUM obj= new SubArrayOfGivenSUM();
        int arr[]= {1,2,3 ,5,7,8};
        List<Integer> myNums =obj.getSubArrayForSUM(arr, 11);
        if(!myNums.isEmpty())
          myNums.stream().forEach(System.out::print);

    }
}
