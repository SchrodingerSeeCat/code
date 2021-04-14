#include <iostream>
#include <stack>
using namespace std;

// https://leetcode-cn.com/problems/clumsy-factorial/
class Solution {
private:
    void calc(stack<int> &num, stack<int> &op) {
        int second = num.top();
        num.pop();
        int first = num.top();
        num.pop();
        switch (op.top()) {
            case 0:
                num.push(first * second);
                break;
            case 1:
                num.push(first / second);
                break;
            case 2:
                num.push(first + second);
                break;
            case 3:
                num.push(first - second);
        }
        op.pop();
    }
public:
    int clumsy(int N) {
        if (N == 1) return N;
        stack<int> num;
        stack<int> op;
        int ops[] = {1, 1, 0, 0};
        for(int i = N, j = 0; i > 0; i--, j++) {
            num.push(i);

            while(!op.empty() && ops[j] <= ops[op.top()]) {
                calc(num, op);
            }

            // 最后一个运算符不需要压入栈
            if (i != 1) op.push(j);

            // 重置运算符
            if (j == 3) j = -1;
        }
        while (!op.empty()) {
            calc(num, op);
        }
        return num.top();
    }
};