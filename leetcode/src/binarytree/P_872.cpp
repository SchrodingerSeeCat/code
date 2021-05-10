#include<vector>

using namespace std;
class Solution {
private:
    void preOrder(TreeNode* node, vector<int> &v) {
        if (node == nullptr) return;
        if (node->left == nullptr && node->right == nullptr) {
            v.push_back(node->val);
        }
        preOrder(node->left, v);
        preOrder(node->right, v);
    }
public:
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> v1;
        vector<int> v2;
        preOrder(root1, v1);
        preOrder(root2, v2);
        if (v1.size() != v2.size()) return false;
        for (int i = 0; i < v1.size(); i++) {
            if (v1[i] != v2[i]) return false;
        }
        return true;
    }
};

