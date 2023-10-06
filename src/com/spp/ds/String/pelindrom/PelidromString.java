package com.spp.ds.String.pelindrom;

public class PelidromString {

    public boolean isPelindromByLambda(String argStr){

        return true;
    }

    public boolean isPelindrom(String argStr){

        char strarry[] = argStr.toCharArray();

        StringBuffer sb = new StringBuffer(argStr);
        sb.reverse();
        System.out.println(sb.equals(argStr));

        return true;
    }
}
