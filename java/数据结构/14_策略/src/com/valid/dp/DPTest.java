package com.valid.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DPTest {
    private static final int n = 41;

    @DisplayName("测试零钱兑换")
    @Test
    public void testCoins() {
        System.out.println(new CoinChange().coinChange(new int[]{1, 5, 20, 25}, 41));
    }

    @DisplayName("测试最大连续序列和")
    @Test
    public void testMaxSubArray() {
        Assertions.assertEquals(6, new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @DisplayName("测试最大上升序列长度")
    @Test
    public void testLTS() {
        Assertions.assertEquals(4, new LengthOfLIS().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    @DisplayName("测试最大公共子序列")
    @Test
    public void testLCS() {
        Assertions.assertEquals(3, new LCS().lcs1(new int[]{1,3,5,9,10}, new int[]{1,4,9,10}));
    }

    @DisplayName("测试最大公共子串")
    @Test
    public void testMaxSubStr() {
        Assertions.assertEquals(3, new MaxSubStr().maxSubStr("ABCBA", "BABCA"));
    }

    @DisplayName("测试01背包")
    @Test
    public void testKnapsack() {
        Assertions.assertEquals(3,
                new Knapsack().maxValue(
                        new int[]{6, 3, 5, 4, 6},
                        new int[]{2, 2, 6, 5, 4},
                        10));
    }
}
