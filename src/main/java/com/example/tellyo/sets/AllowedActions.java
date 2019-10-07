package com.example.tellyo.sets;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class AllowedActions extends BaseSet {

    public AllowedActions() {
        tokens = new HashSet<>(asList("add", "delete", "modify", "clear", "hide"));
    }
}
