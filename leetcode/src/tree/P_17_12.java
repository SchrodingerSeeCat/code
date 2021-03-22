package tree;

public class P_17_12 {
    TreeNode head = new TreeNode(0); // 头节点
    TreeNode prev = null; // 当前节点的父节点
    public TreeNode convertBiNode(TreeNode root) {
        middleOrderTraversal(root);
        return head.right;
    }
    public void middleOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        middleOrderTraversal(node.left);
        if (prev == null) {
            // 第一个节点
            prev = node;
            head.right = node;
        } else {
            prev.right = node;
            prev = node;
        }
        node.left = null;
        middleOrderTraversal(node.right);
    }
}
