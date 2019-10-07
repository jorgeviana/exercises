package com.example.tellyo.sets;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class AllowedActions extends BaseSet {

    private static final HashSet<String> TOKENS = new HashSet<>(asList("add", "delete", "modify", "clear", "hide"));

    public Set<String> getValidTokens() {
        return TOKENS;
    }
}
