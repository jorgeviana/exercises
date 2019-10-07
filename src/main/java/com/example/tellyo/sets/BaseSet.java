package com.example.tellyo.sets;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public abstract class BaseSet {

    abstract Set<String> getValidTokens();

    public String and(String set1, String set2) {
        Set<String> s1 = split(set1);
        Set<String> s2 = split(set2);

        s1.retainAll(getValidTokens());
        s2.retainAll(getValidTokens());

        s1.retainAll(s2);

        return format(s1);
    }

    public String or(String set1, String set2) {
        Set<String> s1 = split(set1);
        Set<String> s2 = split(set2);

        s1.retainAll(getValidTokens());
        s2.retainAll(getValidTokens());

        Set<String> result = new HashSet<>();
        result.addAll(s1);
        result.addAll(s2);

        return format(result);
    }

    private HashSet<String> split(String networksOne) {
        return new HashSet<>(asList(networksOne.split(",")));
    }

    private String format(Set<String> result) {
        return result.stream()
                .collect(joining(","));
    }
}
