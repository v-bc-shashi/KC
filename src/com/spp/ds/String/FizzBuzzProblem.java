package com.spp.ds.String;

/*Print the Number from 1 to 100 each on new line.
For each multiple of 3 print Fizz
For each multiple of 5 print Buzz
Fpr Each multiple of both 3 and 5 print FizzBuzz.*/


public class FizzBuzzProblem {

    public static void main(String[] args) {
        for(int i=0; i<100;i++){

            if(i%3==0 && i%5==0)
                System.out.println("FiZZBuzz");
            else if(i%3==0)
                System.out.println("FiZZ");
            else if(i%5==0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

}
