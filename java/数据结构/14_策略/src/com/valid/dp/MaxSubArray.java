package com.valid.dp;

// https://leetcode-cn.com/problems/maximum-subarray/
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];

        int dp = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if (dp > max) {
                max = dp;
            }
        }
        return max;
    }
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}
