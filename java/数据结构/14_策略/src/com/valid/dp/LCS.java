package com.valid.dp;

public class LCS {

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0) return 0;
        if (text2 == null || text2.length() == 0) return 0;

        if (text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }

        char[] chars1 = text1.toCharArray();
        char[] chars2 = text1.toCharArray();

        int[] dp = new int[chars2.length + 1];

        for (int i = 1; i <= chars1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= chars2.length; j++) {
                int leftTop = cur; // 保存左上角的值
                cur = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[chars2.length];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text1.length() == 0) return 0;
        if (text2 == null || text2.length() == 0) return 0;

        if (text1.length() < text2.length()) {
            return longestCommonSubsequence1(text2, text1);
        }

        int[] dp = new int[text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            int cur = 0;
            for (int j = 1; j <= text2.length(); j++) {
                int leftTop = cur; // 保存左上角的值
                cur = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[text2.length()];
    }
    // 空间优化3
    public int lcs(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;

        if (nums1.length < nums2.length) {
            return lcs(nums2, nums1);
        }

        int[] dp = new int[nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur; // 保存左上角的值
                cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[nums2.length];
    }
    // 空间优化2
    public int lcs4(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[] dp = new int[nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            int cur = 0;
            for (int j = 1; j <= nums2.length; j++) {
                int leftTop = cur; // 保存左上角的值
                cur = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = leftTop + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }

        return dp[nums2.length];
    }

    // 空间优化1
    public int lcs3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[2][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j - 1] + 1;
                } else {
                    dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[i & 1][j - 1]);
                }
            }
        }

        return dp[nums1.length & 1][nums2.length];
    }

    // 动态规划
    public int lcs2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
    // 递归实现
    public int lcs1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return 0;
        if (nums2 == null || nums2.length == 0) return 0;
        return lcs1(nums1, nums1.length, nums2, nums2.length);
    }

    private int lcs1(int[] nums1, int i, int[] nums2, int j) {
        if (i == 0 || j == 0) return 0;
        if (nums1[i - 1] == nums2[j - 1]) {
            return lcs1(nums1, i - 1, nums2, j - 1) + 1;
        }
        return Math.max(lcs1(nums1, i - 1, nums2, j),
                        lcs1(nums1, i, nums2, j - 1));
    }
}
