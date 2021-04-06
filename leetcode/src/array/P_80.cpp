#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int sum = 0, count = 0, temp = nums[0];
        for (int i = 0; i < nums.size(); i++) {
            if (temp == nums[i]) {
                count++;
            } else {
                temp = nums[i];
                count = 1;
            }
            if (count <= 2) {
                nums[sum++] = nums[i];
            }
        }
        return sum;
    }
};
