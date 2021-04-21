#include <string>
#include <vector>

using namespace std;
// https://leetcode-cn.com/problems/implement-strstr/
class Solution {
public:
    int strStr1(string haystack, string needle) {
        if (needle == "") return 0;
        for(int i = 0; i + needle.size() <= haystack.size(); i++) {
            int j, k;
            for(j = 0, k = i; j < needle.size(); j++, k++) {
                if (needle[j] != haystack[k]) {
                    break;
                }
            }
            if (j == needle.size()) {
                return i;
            }
        }
        return -1;
    }
    int strStr2(string haystack, string needle) {
        if (needle == "") return 0;

        // next数组
        vector<int> next(needle.size());
        for(int i = 0; i < next.size(); i++) {
            next[i] = 0; // 初始化
        }
        for(int i = 1; i < needle.size(); i++) {
            for(int m = 0; m <= i; m++) {
                int max = 0;
                for(int j = 0, k = i; j <= m; j++, k--) {
                    if (needle[j] != needle[k]) {
                        break;
                    }
                    max++;
                }
                if (next[i + 1] < max) {
                    next[i + 1] = max;
                }
            }
        }
        int i, j;
        for(i = 0, j = 0; i < haystack.size() && j < needle.size(); i++) {
            if (needle[j] != haystack[i]) {
                j = next[j];
            } else {
                j++;
            }
        }
        return j == needle.size() ? j : -1;
    }
};