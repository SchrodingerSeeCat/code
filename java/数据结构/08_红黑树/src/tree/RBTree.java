package tree;

import java.util.Comparator;

public class RBTree<E> extends BalanceBinarySearchTree<E>{
    // 红黑树的颜色
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }
    public RBTree() {
        this(null);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        // 没有父节点，添加的是根节点
        if (parent == null) {
            black(node);
            return;
        }

        // 父节点是黑色的，不需要处理
        if (isBlack(node)) return;

        // uncle节点
        Node<E> uncle = parent.sibling();
        // grand节点
        Node<E> grand = red(parent.parent);
        if(isRed(node)) {
            // 叔父节点是红色
            black(node);
            black(uncle);

            // 把祖父节点当成是新添加的节点
            afterAdd(red(grand));
            return;
        }

        // 叔父节点不是红色
        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { // LL
                black(parent);
            } else {
                // LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);

        } else {
            if (node.isLeftChild()) { // RL
                black(node);
                rotateRight(parent);
            } else {
                // RR
                black(parent);
            }
            rotateLeft(grand);
        }

    }

    // 染色
    private Node<E> color(Node<E> node, boolean color) {
        if (node != null) {
            ((RBNode<E>)node).color = color;
        }
        return node;
    }

    // 染成红色
    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }
    // 染成黑色
    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    // 查看节点的颜色
    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    // 判断节点的颜色
    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }
    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    // 重写创建节点的方法
    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }

    // 红黑树的节点
    private static class RBNode<E> extends Node<E> {
        // 新添加的节点的颜色默认为红色，方便统计
        // 因为红黑树的任意一条路径所拥有的黑色节点是相同的
        boolean color = RED;
        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            if (color == RED) {
                sb.append("R_");
            } else {
                sb.append("B_");
            }
            sb.append(element);
            return sb.toString();
        }
    }
}
