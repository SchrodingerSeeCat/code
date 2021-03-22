package array;

// https://leetcode-cn.com/problems/two-sum/
public class P_1 {
    public int[] twoSum(int[] nums, int target) {
        int first = 0, second = 0;
        int firstIndex = -1, secondIndex = -1;
        for(int i = 0; i < nums.length - 1; i++) {
            first = nums[i];
            second = target - nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] == second) {
                    firstIndex = i;
                    secondIndex = j;
                    break;
                }
            }
        }
        return new int[]{firstIndex, secondIndex};
    }
}
