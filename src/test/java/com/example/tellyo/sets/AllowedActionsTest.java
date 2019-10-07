package com.example.tellyo.sets;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllowedActionsTest {

    @Test
    public void and() {
        String actionsOne = "add,delete,qwerty";
        String actionsTwo = "delete,asdfg,update";

        String andResult = new AllowedActions().and(actionsOne, actionsTwo);

        assertThat(andResult.split(",")).containsExactlyInAnyOrder("delete");
    }

    @Test
    public void or() {
        String actionsOne = "add,delete,qwerty";
        String actionsTwo = "delete,asdfg,update";

        String orResult = new AllowedActions().or(actionsOne, actionsTwo);

        assertThat(orResult.split(",")).containsExactlyInAnyOrder("add", "delete");
    }
}
