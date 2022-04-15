package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<String> topKFrequent(String[] words, int k) {
        return Stream.of(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<String,Long>comparingByKey()))
                .limit(k)
                .map(Map.Entry::<String,Long>getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] Example1 = {"i","love","leetcode","i","love","coding"};
        String[] Example2 = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(Example1,2));
        System.out.println(topKFrequent(Example2,4));
    }
}
