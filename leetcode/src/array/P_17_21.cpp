#include <vector>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int count = 0, sum = 0, i = 0, j = height.size() - 1, k = 1;
        for(auto t = height.begin(); t < height.end(); t++) {
            sum = sum + *t;
        }
        while (i < j) {
            if (height[i] != k) {
                i++;
            }
            if (height[j] != k) {
                j--;
            }

            if (height[i] == height[j] && height[i] == k) {
                count = count + (j - i);
                i++;
                j--;
                k++;
            }
        }
        return sum - count;
    }
};

