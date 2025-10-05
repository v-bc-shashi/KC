package com.spp.coreJava.jdk8.lambdaX;

import com.spp.coreJava.jdk8.lambdaX.Calculater;

public class DemoLambda {
    public static void main(String[] args) {

        Calculater calc= (a, b)->{
            System.out.println("Output of Lambda is");
            System.out.println(a+b);
        };

        System.out.println("Demo of Lambda is");
        calc.calculate(100, 200);

        //new implmentation

        calc= (a,b)->{
            System.out.println("Output of Lambda is");
            System.out.println(a*b);
        };

        calc.calculate(20,70);

    }
}
