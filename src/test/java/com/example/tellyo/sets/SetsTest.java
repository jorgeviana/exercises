package com.example.tellyo.sets;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SetsTest {

    @Test
    public void and() {
        String networksOne = "twitter,facebook";
        String networksTwo = "facebook,youtube,blablabla";

        String andResult = new SocialMediaNetworks().and(networksOne, networksTwo);

        assertThat(andResult.split(",")).containsExactlyInAnyOrder("facebook");
    }

    @Test
    public void or() {
        String networksOne = "twitter,facebook";
        String networksTwo = "facebook,youtube,blablabla";

        String orResult = new SocialMediaNetworks().or(networksOne, networksTwo);

        assertThat(orResult.split(",")).containsExactlyInAnyOrder("twitter", "facebook", "youtube");
    }
}
