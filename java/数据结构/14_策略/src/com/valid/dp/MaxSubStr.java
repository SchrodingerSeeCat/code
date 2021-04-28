package com.valid.dp;

// 最长公共子串
public class MaxSubStr {
    public int maxSubStr(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        if (str1.length() == 0 || str2.length() == 0) return 0;
        if (str1.length() < str2.length()) {
            return maxSubStr(str2, str1);
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[] dp = new int[chars2.length + 1];
        int max = 0;
        for(int i = 1; i < chars1.length; i++) {
            int cur = 0;
            for (int j = 1; j < chars2.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = leftTop + 1;
                    if (dp[j] > max) max = dp[j];
                } else {
                    dp[j] = 0;
                }
            }
        }

        return max;
    }
    public int maxSubStr1(String str1, String str2) {
        if (str1 == null || str2 == null) return 0;
        if (str1.length() == 0 || str2.length() == 0) return 0;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        int max = 0;
        for(int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                }
            }
        }

        return max;
    }
}
