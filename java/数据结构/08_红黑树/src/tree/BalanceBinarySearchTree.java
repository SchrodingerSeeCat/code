package tree;

import java.util.Comparator;

public class BalanceBinarySearchTree<E> extends BinarySearchTree<E> {
    public BalanceBinarySearchTree(Comparator<E> comparator) {
        super(comparator);
    }
    // 左旋转
    protected void rotateLeft(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;

        grand.right = parent.left;
        parent.left = grand;

        afterRotate(grand, parent, child);
    }
    // 右旋转
    protected void rotateRight(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;

        grand.left = parent.right;
        parent.right = grand;

        afterRotate(grand, parent, child);
    }
    // 旋转之后要做的事
    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
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
    }

    protected void rotate(
            Node<E> r,
            Node<E> a, Node<E> b, Node<E> c,
            Node<E> d,
            Node<E> e, Node<E> f, Node<E> g) {
        // 让d成为这棵子数的根节点
        d.parent = r.parent;
        if (r.isLeftChild()) {
            r.parent.left = d;
        } else if (r.isRightChild()) {
            r.parent.right = d;
        } else {
            root = d;
        }

        // b是d的左子树，a成为b的左子树，c成为b的右子树
        b.left = a;
        if (a != null) a.parent = b;
        b.right = c;
        if (c != null) c.parent = b;


        // f是d的右子树，e成为f的左子树，g成为f的右子树
        f.left = e;
        if (e != null) e.parent = f;
        f.right = g;
        if (g != null) g.parent = f;


        // d为根节点，左子树为b，右子树为f
        d.left = b;
        d.right = f;
        b.parent = d;
        f.parent = d;
    }
}
