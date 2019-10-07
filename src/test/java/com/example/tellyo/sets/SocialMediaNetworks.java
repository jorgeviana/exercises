package com.example.tellyo.sets;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class SocialMediaNetworks extends BaseSet {

    private static final HashSet<String> TOKENS = new HashSet<>(asList("facebook", "twitter", "youtube", "instagram", "snapchat"));

    public Set<String> getValidTokens() {
        return TOKENS;
    }
}
