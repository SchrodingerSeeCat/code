package com.valid.dp;

// 最长上升子序列
public class LengthOfLIS {

    // 牌堆算法
    public int lengthOfLIS(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int begin = 0;
            int end = len;
            while (begin < end) { // 二分搜索查找要放的牌堆的位置
                int mid = (begin + end) >> 1;
                if (num <= dp[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }
            dp[begin] = num; // 包含新建牌堆
            if(begin == len) len++;
        }
        return len;
    }

    // 牌堆算法
    public int lengthOfLIS2(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int j = 0;
            while (j < len) {
                if (dp[j] >= num) {
                    dp[j] = num;
                    break;
                }
                j++;
            }
            if (j == len) dp[len++] = num;
        }
        return len;
    }
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] ) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
