package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class P_173 {
    class BSTIterator {
        private List<Integer> list; // 保存节点
        private int index; // 当前已遍历的元素的索引

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            list.add(0);
            index = 0;
            middleOrderTraversal(root);
        }

        public int next() {
            return list.get(++index);
        }

        public boolean hasNext() {
            return index != list.size() - 1;
        }

        private void middleOrderTraversal(TreeNode node) {
            if (node == null) return;
            middleOrderTraversal(node.left);
            list.add(node.val);
            middleOrderTraversal(node.right);
        }
    }
}
