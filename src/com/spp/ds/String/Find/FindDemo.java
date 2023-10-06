package com.spp.ds.String.Find;

public class FindDemo {

    private static String str;
    private static String geeks;

    public static void main(String[] args) {
        System.out.println(".....................Out put is ................");
        FindStringProblems fspObj = new FindStringProblems();
        String str= "geeksforgeeks";
       // str = geeks;
     //   char ch= fspObj.getFirstRepeatedCharactor(str);
        char ch= fspObj.getFirstRepeatedCharactorBYMAP(str);
        System.out.println("Out put is : "+ ch);

    }
}
