#include "TreeNode.h"

using namespace std;
class Solution {
private:
    void middleOrderTraversal(TreeNode* root, int &low, int &high, int &sum) {
        if (root == nullptr) return;
        if (root->val >= low && root->val <= high) {
            sum = sum + root->val;
        }
        middleOrderTraversal(root->left, low, high, sum);
        middleOrderTraversal(root->right, low, high, sum);
    }
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        int sum = 0;
        middleOrderTraversal(root, low, high, sum);
        return sum;
    }
};