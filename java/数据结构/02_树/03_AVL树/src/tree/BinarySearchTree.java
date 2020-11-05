package tree;
import tree.BinaryTree;

import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree {
    private Comparator<E> comparator;

    // 比较器
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }
    public BinarySearchTree(){
        this(null);
    }

    // 判断元素是否存在二叉树中
    public boolean contains(E element) {
        return node(element) != null;
    }

    // 创建节点
    // 添加节点
    protected Node<E> createNode(E element, Node parent){
        return new Node<>(element, parent);
    }
    public void add(E element){
        elementNotNullCheck(element);
        // 添加第一节点
        if(root == null) {
            root = createNode(element, null);

            // 新添加节点之后的处理
            afterAdd(root);

            size++;
            return;
        }
        // 添加的不是第一个节点
        // 找到父节点
        Node<E> node = root;
        Node<E> nodeParent = null;
        int cmp = 0;
        while(node != null) {
            // 保存父节点
            nodeParent = node;
            cmp = compare(element, node.element);
            if (cmp > 0) {
                node = node.right;
            } else if(cmp < 0) {
                node = node.left;
            } else {
                // 相等覆盖
                node.element = element;
                return;
            }
        }

        // 插入父节点的左边或者右边
        Node<E> newNode = createNode(element, nodeParent);
        if (cmp > 0) {
            nodeParent.right = newNode;
        } else {
            nodeParent.left = newNode;
        }

        // 新添加节点之后的处理
        afterAdd(newNode);

        size++;
    }

    // 添加node之后的调整
    protected void afterAdd(Node<E> node) {

    }


    // 删除节点
    public void remove(E element) {
        remove(node(element));
    }
    private void remove(Node<E> node){
        if(node == null) return;
        if(node.hasTwoChildren()) {
            // 找到后继节点
            Node<E> tempNode = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = tempNode.element;
            // 删除后继节点
            node = tempNode;
        }
        // 删除node节点 此时node的度为1或者0
        Node<E> replacement = node.left != null ? node.left : node.right;
        if(replacement != null) {
            // node是度为1的节点
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left right 指向
            if (node.parent == null) { // node == root
                root = replacement;
            } else if(node == node.parent.left) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }
        } else if(node == root){
            // 是叶子节点并且度为0
            root = null;
        } else {
            // 是叶子节点，不是根节点
            if(node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }
        size--;
    }

    // 返回根节点
    public Node<E> root(){
        return root;
    }

    // 返回左子节点
    public Node<E> left(Node<E> node){
        return node.left;
    }

    // 返回右子节点
    public Node<E> right(Node<E> node){
        return node.right;
    }

    // 打印节点的值
    public E string(Node<E> node){
        return node.element;
    }

    // 打印二叉树(中序遍历)
    public String toString(){
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }
    private void toString(Node<E> node, StringBuilder sb, String prefix){
        if(node == null) return;
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left, sb, prefix + "L--");
        toString(node.right, sb, prefix + "R--");
    }
    // 比较元素
    /*
    * 返回值 0  e1 == e2
    * 返回值 >0 e1 > e2
    * 返回值 <0 e1 < e2
    * */
    private int compare(E e1, E e2) {
        if(comparator != null) {
            return this.comparator.compare(e1, e2);
        }
        // 强制转换元素具有可比较性
        return ((Comparable<E>)e1).compareTo(e2);
    }
    // 检测元素是否为空
    private void elementNotNullCheck(E element) {
        if(element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    // 查找元素的节点位置
    private Node<E> node(E element) {
        Node<E> node = root;
        while(node != null) {
            int cmp = compare(element, node.element);
            if(cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
}
