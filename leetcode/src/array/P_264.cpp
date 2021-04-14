#include <vector>
#include <iostream>

using namespace std;

// https://leetcode-cn.com/problems/ugly-number-ii/
class Solution {
public:
    int nthUglyNumber(int n) {
        vector<int> vector(n);
        vector[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int num2, num3, num5;
        for(int i = 1; i < n; i++) {
            num2 = 2 * vector[p2];
            num3 = 3 * vector[p3];
            num5 = 5 * vector[p5];
            vector[i] = min(min(num2, num3), num5);
            if (vector[i] == num2) {
                p2++;
            }
            if (vector[i] == num3) {
                p3++;
            }
            if (vector[i] == num5) {
                p5++;
            }
        }
        return vector[n - 1];
    }
};