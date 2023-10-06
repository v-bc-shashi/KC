package com.spp.coreJava.jdk8.MapStream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/************
 Suppose we have input String - aaaabbbbbccccdddddeeff
*
* Print that Which character occured how many times.
*
* */
public class MappingWithCharacterCount {

    public Map<String, Long> getCharCountPurejava8(String argStr){
        Map<String, Long> result = new HashMap<>();
       Stream<Character> charStream = argStr.chars().mapToObj(c->(char)c);
       result =Arrays.stream(argStr.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) ;
        return result;
    }

    public Map<Character, Long> getCharCountByListJava8(String argStr){
        Map<Character, Long> result = new HashMap<>();
        List<Character> allChars = argStr.chars().mapToObj(c->(char)c).collect(Collectors.toList());
        result =allChars.stream().collect(Collectors.groupingBy(obj->obj, Collectors.counting() ));
        return result;
    }

}
