#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) return "";
        int min = strs[0].size();
        for (int i = 0; i < strs.size(); i++) {
            if (strs[i].size() == 0) return "";
            if (strs[i].size() > min) {
                min = strs[i].size();
            }
        }

        string str = "";
        for (int i = 0; i < min; i++) {
            char ch = strs[0][i];
            for (int j = 1; j < strs.size(); j++) {
                if (strs[j][i] != ch) return str;
            }
            str += ch;
        }
        return str;
    }
};
