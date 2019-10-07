package com.example.tellyo.sets;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public abstract class BaseSet {

    abstract Set<String> getValidTokens();

    public String and(String string1, String sestring2) {
        Set<String> s1 = removeInvalidTokens(split(string1));
        Set<String> s2 = removeInvalidTokens(split(sestring2));

        return format(and(s1, s2));
    }

    public String or(String string1, String string2) {
        Set<String> s1 = removeInvalidTokens(split(string1));
        Set<String> s2 = removeInvalidTokens(split(string2));

        return format(or(s1, s2));
    }

    private HashSet<String> split(String networksOne) {
        return new HashSet<>(asList(networksOne.split(",")));
    }

    private Set<String> removeInvalidTokens(Set<String> s) {
        Set<String> result = new HashSet<>(s);
        result.retainAll(getValidTokens());
        return result;
    }

    private Set<String> and(Set<String> s1, Set<String> s2) {
        Set<String> result = new HashSet<>(s1);
        result.retainAll(s2);
        return result;
    }

    private Set<String> or(Set<String> s1, Set<String> s2) {
        Set<String> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    private String format(Set<String> result) {
        return result.stream()
                .collect(joining(","));
    }
}
