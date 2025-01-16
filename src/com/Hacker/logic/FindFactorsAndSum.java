package com.Hacker.logic;

import java.util.ArrayList;
import java.util.List;

/*******************Problem ******
 * For each number in an array, get the sum of its factors. Return an array of results.
 *Example
 *  arr = [12]
 * The factors of arr[0] = 12 are [1, 2, 3, 4, 6, 12]. The sum of these factors is 28. Return the array [28].
 *Returns  long[n]:  the sums calculated for each arr[i]
 * * Sample Input 0
 * * STDIN    Function
 * -----    --------
 * 2    →   arr[] size n = 2
 * 2    →   arr = [2, 4]
 * 4
 * Sample Output 0
       3
       7
 * * */
public class FindFactorsAndSum {
   public static ArrayList findAllFactorSum(int argNum){
        ArrayList<Integer> allFactores = new ArrayList<>();
       if(argNum==0) {
           allFactores.add(0);
           allFactores.add(0);
       }else if(argNum==1) {
           allFactores.add(1);
           return allFactores;
       }else{
         for(int i=1; i<argNum; i++){
             if(argNum%i==0)
                 allFactores.add(i);
         }
       }
       return allFactores;
    }
    public static void main(String[] args) {
        int[] inputArr={4,7,9,12};
         for(int i:inputArr){
            List<Integer> allNumbers = FindFactorsAndSum.findAllFactorSum(i);
            System.out.println("Number is  : "+ i);
            System.out.println("Factors are : ");
            allNumbers.stream().forEach(num -> System.out.print( num+" ,"));
            System.out.println("\nSum Of Factors are: " );
            // GET Sum of ALL Numbers of Array List - allNumbers.stream().mapToInt(num->num).sum() //
            System.out.println(allNumbers.stream().mapToInt(num->num).sum()+i);
            System.out.println("\n--------------------\n");
        }
    }
}
