package com.example.tellyo.sets;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SocialMediaNetworksTest {

    private static final String NETWORKS_ONE = "twitter,facebook";
    private static final String NETWORKS_TWO = "facebook,youtube,blablabla";

    private SocialMediaNetworks socialMediaNetworks;

    @Before
    public void setUp() {
        socialMediaNetworks = new SocialMediaNetworks();
    }

    @Test
    public void and() {
        String andResult = socialMediaNetworks.and(NETWORKS_ONE, NETWORKS_TWO);

        assertThat(andResult.split(",")).containsExactlyInAnyOrder("facebook");
    }

    @Test
    public void or() {
        String orResult = socialMediaNetworks.or(NETWORKS_ONE, NETWORKS_TWO);

        assertThat(orResult.split(",")).containsExactlyInAnyOrder("twitter", "facebook", "youtube");
    }
}
