package array;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
public class P_26 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(k != i && nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }
        return k + 1;
    }
}
