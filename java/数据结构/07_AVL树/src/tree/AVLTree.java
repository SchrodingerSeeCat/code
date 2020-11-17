package tree;
// 平衡二叉树
import java.sql.SQLOutput;
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
            if (node.isLeftChild()) {
                // LL情况 将grand右旋转
                rotateRight(grand);
            } else {
                // LR情况 先对Parent进行左旋转转换为LL情况 再将grand右旋转
                rotateLeft(parent);
                rotateRight(grand);
            }

        } else { // R
            if (node.isRightChild()) {
                // RR
                rotateLeft(grand);
            } else {
                // RL情况 将parent右旋转转换为RR情况 再将grand左旋转
                rotateRight(parent);
                rotateLeft(grand);
            }
        }
    }

    // 左旋转
    private void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;

        grand.right = parent.left;
        parent.left = grand;

        afterRotate(grand, parent, child);
    }
    // 右旋转
    private void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;

        grand.left = parent.right;
        parent.right = grand;

        afterRotate(grand, parent, child);
    }
    // 旋转之后要做的事
    private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        // 让parent成为子树的根节点
        parent.parent = grand.parent;

        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()){
            grand.parent.right = parent;
        } else {
            root = parent;
        }
        // child的parent
        if (child != null) {
            child.parent = grand;
        }

        // 更新grand的parent
        grand.parent = parent;

        // 更新高度
        updateHeight(grand);
        updateHeight(parent);
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
