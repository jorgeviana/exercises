package com.example.tellyo.sets;

import java.util.HashSet;

import static java.util.Arrays.asList;

public class SocialMediaNetworks extends BaseSet {

    public SocialMediaNetworks() {
        tokens = new HashSet<>(asList("facebook", "twitter", "youtube", "instagram", "snapchat"));
    }
}
