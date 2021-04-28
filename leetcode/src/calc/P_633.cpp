#include <cmath>

// https://leetcode-cn.com/problems/sum-of-square-numbers/
using namespace std;
class Solution {
public:
    bool judgeSquareSum(int c) {
        long a = 0, b = sqrt(c);

        while(a <= b) {
            if ((a * a + b * b) == c) return true;
            if ((a * a + b * b) > c) b--;
            a++;
        }

        return false;
    }
};