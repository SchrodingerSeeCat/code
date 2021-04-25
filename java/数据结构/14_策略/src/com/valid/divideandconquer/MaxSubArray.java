package com.valid.divideandconquer;

public class MaxSubArray {

    // 分治
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length);
    }
    public int maxSubArray(int[] nums, int begin, int end) {
        // 如果只有一个元素，那最大序列和就是这个元素本身
        if (end - begin < 2) return nums[begin];
        int mid = (begin + end) >> 1;

        // 求出横跨左右两边的子序列最大值的和
        int leftMax = Integer.MIN_VALUE, leftNum = 0;
        for (int i = mid - 1; i >= begin; i--) {
            leftNum += nums[i];
            if (leftMax < leftNum) leftMax = leftNum;
        }
        int rightMax = Integer.MIN_VALUE, rightNum = 0;
        for (int i = mid; i < end; i++) {
            rightNum += nums[i];
            if (rightMax < rightNum) rightMax = rightNum;
        }

        return Math.max(
                    Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)),
                    leftMax + rightMax);
    }
    // 暴力解法
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        for (int begin = 0; begin < nums.length; begin++) {
            int sum = 0;
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
