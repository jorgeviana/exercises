package com.example.tellyo.sets;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class SocialMediaNetworks extends BaseSet {

    public SocialMediaNetworks() {
        tokens = new HashSet<>(asList("facebook", "twitter", "youtube", "instagram", "snapchat"));
    }

    public String and(String set1, String set2) {
        Set<String> n1 = split(set1);
        Set<String> n2 = split(set2);

        n1.retainAll(getValidTokens());
        n2.retainAll(getValidTokens());

        n1.retainAll(n2);

        return format(n1);
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

    private Set<String> getValidTokens() {
        return tokens;
    }

    private HashSet<String> split(String networksOne) {
        return new HashSet<>(asList(networksOne.split(",")));
    }

    private String format(Set<String> result) {
        return result.stream()
                .collect(joining(","));
    }
}
