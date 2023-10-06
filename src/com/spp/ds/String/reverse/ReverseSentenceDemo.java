package com.spp.ds.String.reverse;

public class ReverseSentenceDemo {
    public static void main(String[] args) {
        /***************DEMO for REVERSE SENTENCE Without LIB ****************/
        System.out.println("..... DEMO Stated.....................\n");
        ReverseSentence objrvs = new ReverseSentence();
     //   String rsStr = objrvs.reverseWithoutInbuiltFunc("This is Shashi Prasad");
      //  String rsStr = objrvs.reverseWithInbuiltFunc("This is Shashi Prasad");
        String rsStr = objrvs.onlyInbuiltFucntion("This is Shashi Prasad");
        System.out.println(rsStr);
        System.out.println("\n.....DEMO DONE.....................");
        /***************DEMO for REVERSE SENTENCE Without LIB ****************/
    }
}
