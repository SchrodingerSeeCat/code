package tree;
// 平衡二叉树
import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E>{
    // 比较器
    public AVLTree(Comparator<E> comparator){
        super(comparator);
    }

    // 重写添加节点之后的操作
    @Override
    protected void afterAdd(Node<E> node) {
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
        if (parent.isLeftChild()) { // L
            if (node.isRightChild()) {
                // LR情况 先对Parent进行左旋转转换为LL情况 再将grand右旋转
                rotateLeft(parent);
            }
            // LL情况 将grand右旋转
            rotateRight(grand);
        } else { // R
            if (node.isLeftChild()) {
                // RL情况 将parent右旋转转换为RR情况 再将grand左旋转
                rotateRight(parent);
            }
            // RR情况 将grand左旋转
            rotateLeft(grand);
        }
    }

    // 左旋转
    private void rotateLeft(Node<E> node) {

    }
    // 右旋转
    private void rotateRight(Node<E> node) {
        Node<E> parent = node.left;
        node.left = node.left.right;
        parent.right = node;

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
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    // AVL的节点
    private static class AVLNode<E> extends Node<E>{
        // 节点的高度, 默认高度为1
        int height = 1;
        public AVLNode(E element, Node<E> parent) {
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
