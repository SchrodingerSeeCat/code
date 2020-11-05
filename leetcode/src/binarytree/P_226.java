package binarytree;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode-cn.com/problems/invert-binary-tree/
public class P_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return  root;
    }
}
