package com.spp.ds.String.reverse;

import java.util.LinkedList;

public class ReverseSentence {


    private StringBuilder builder;

    public String reverseWithoutInbuiltFunc(String argSentence) {
        StringBuilder builder;
        LinkedList<String> allWords = new LinkedList<String>();
        int allWordsIndexPointer = 0;
        builder = new StringBuilder();
        for (int i = 0; i < argSentence.length(); i++) {
            char ch = argSentence.charAt(i);
            if (ch == ' ' || ch == '\n') {
                allWords.add(allWordsIndexPointer++, builder.toString());
                builder = new StringBuilder();
            }
            builder.append(ch);
        }
        allWords.add(allWordsIndexPointer, builder.toString());

        builder = new StringBuilder();

        while (allWordsIndexPointer >= 0) {
            builder.append(allWords.get(allWordsIndexPointer--));
            builder.append(" ");
        }
        return builder.toString();
    }

    public String reverseWithInbuiltFunc(String argSentence) {
        String allWords[] = argSentence.split(" ");
        int allWordIndexPointer = allWords.length-1;
        StringBuilder builder = new StringBuilder();

        while(allWordIndexPointer>=0){
            builder.append(allWords[allWordIndexPointer--]);
            builder.append(" ");
        }

        return  builder.toString();
    }
    public String onlyInbuiltFucntion(String argSentence) {
        // this will reverse the each charactor so it will not work.
        StringBuilder builder = new StringBuilder(argSentence);
        return  builder.reverse().toString();
    }
}
