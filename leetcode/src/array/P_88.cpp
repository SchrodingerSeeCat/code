#include <vector>
using namespace std;

// https://leetcode-cn.com/problems/merge-sorted-array/
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {

        for(int i = m - 1, j = n -1, t = m + n - 1; j >= 0; t--) {
            if (i >= 0 && nums2[j] <= nums1[i]) {
                nums1[t] = nums1[i];
                i--;
            } else if (j >= 0 && ( i < 0 || nums2[j] > nums1[i])){
                nums1[t] = nums2[j];
                j--;
            }
        }
    }
};