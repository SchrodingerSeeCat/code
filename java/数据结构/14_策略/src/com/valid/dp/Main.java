package com.valid.dp;

import org.junit.jupiter.api.Test;

public class Main {
    private static final int n = 41;
    @Test
    public void testCoins() {
        System.out.println(new CoinChange().coinChange(new int[]{1, 5, 20, 25}, 41));
    }
}
