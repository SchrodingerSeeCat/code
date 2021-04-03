package array;

import com.sun.source.tree.BinaryTree;

// https://leetcode-cn.com/problems/132-pattern/
public class P_456 {
    public boolean find132pattern(int[] nums) {
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] < nums[j] && nums[k] > nums[i]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
