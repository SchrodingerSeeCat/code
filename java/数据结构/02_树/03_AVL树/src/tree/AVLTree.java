package tree;
// 平衡二叉树
import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree{
    // 比较器
    public AVLTree(Comparator<E> comparator){
        super(comparator);
    }

    // 重写添加节点之后的操作
    @Override
    protected void afterAdd(Node node) {
        while((node = node.parent) != null) {
            if(isBalanced(node)) {
                // 平衡更新高度
                updateHeight(node);
            } else {
                // 不平衡恢复平衡
                rebalance(node);
                break;
            }
        }
    }

    // 恢复平衡
    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
    }

    // 判断当前节点是否平衡
    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    // 更新节点的高度
    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }

    // 重写创建节点
    @Override
    protected Node createNode(Object element, Node parent) {
        return new AVLNode(element, parent);
    }

    // AVL的节点
    private static class AVLNode<E> extends Node{
        // 节点的高度, 默认高度为1
        int height = 1;
        public AVLNode(E element, Node parent) {
            super(element, parent);
        }
        // 平衡因子
        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        // 更新自身节点高度
        public void updateHeight(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = Math.max(leftHeight, rightHeight) + 1;
        }

        // 查找高的子节点
        public Node<E> tallerChild(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;

            if(leftHeight > rightHeight) return left;
            if(leftHeight < rightHeight) return right;

            // 相等返回左子节点
            return isLeftChild() ? left : right;
        }
    }
}
