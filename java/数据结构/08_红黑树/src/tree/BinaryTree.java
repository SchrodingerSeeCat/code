package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
    protected int size;
    protected Node<E> root;

    // 返回二叉搜索树的大小
    public int size(){
        return size;
    }

    // 判断二叉搜索树是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 清空二叉搜索树
    public void clear(){
        root = null;
        size = 0;
    }

    // 二叉树节点操作虚构类
    public static abstract class Visitor<E>{
        // 返回true，代表停止遍历
        boolean stop = false;
        abstract boolean visit(E element);
    }
    // 层次遍历操作
    public void levelOrder(Visitor<E> visitor) {
        if(root == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            if(visitor.visit(node.element)) return;
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
    }

    // 前序遍历操作
    public void preOrder(Visitor<E> visitor) {
        if(visitor == null) return;
        preOrder(root, visitor);
    }
    public void preOrder(Node<E> node, Visitor<E> visitor){
        if(node == null || visitor.stop) return;

        visitor.stop = visitor.visit(node.element);

        preOrder(node.left, visitor);
        preOrder(node.right, visitor);
    }

    // 中序遍历操作
    public void inOrder(Visitor<E> visitor) {
        if(visitor == null) return;
        inOrder(root, visitor);
    }
    public void inOrder(Node<E> node, Visitor<E> visitor){
        if(node == null || visitor.stop) return;
        inOrder(node.left, visitor);

        if(visitor.stop) return;
        visitor.stop = visitor.visit(node.element);

        inOrder(node.right, visitor);
    }

    // 后序遍历操作
    public void postOrder(Visitor<E> visitor) {
        if(visitor == null) return;
        postOrder(root, visitor);
    }
    public void postOrder(Node<E> node, Visitor<E> visitor){
        if(node == null || visitor.stop) return;
        postOrder(node.left, visitor);
        postOrder(node.right, visitor);

        if(visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    // 判断是否是完全二叉树
    public boolean isComplete(){
        if(root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while(!queue.isEmpty()) {
            Node<E> node = queue.poll();

            if(leaf && !node.isLeaf()) return false;

            if(node.left != null) {
                queue.offer(node.left);
            } else if(node.right != null) {
                return false;
            }

            if(node.right != null) {
                queue.offer(node.right);
            } else {
                // 是叶子节点
                leaf = true;
            }
        }
        return true;
    }
    protected static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
        // 判断是否为叶子节点
        public boolean isLeaf(){
            return left == null && right == null;
        }

        // 判断是否是度为2的节点
        public boolean hasTwoChildren(){
            return left != null && right != null;
        }

        // 判断当前节点是不是父节点的左孩子
        public boolean isLeftChild(){
            return parent != null && this == this.parent.left;
        }

        // 判断当前节点是不是父节点的右孩子
        public boolean isRightChild(){
            return parent != null && this == this.parent.right;
        }

        // 返回兄弟节点
        public Node<E> sibling() {
            if (isLeftChild()) return parent.right;
            if (isRightChild()) return parent.left;

            // 根节点没有兄弟节点
            return null;
        }
    }

    // 寻找某一节点的前驱节点
    // 即它中序遍历的前一个节点
    protected Node<E> predecessor(Node<E> node){
        if(node == null) return null;

        // 前驱节点在左子树中
        Node<E> p = node.left;
        if(p != null)  {
            while(p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while(node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        // 如果父节点为null 则前驱节点为null
        // 如果当前节点为父节点的右节点，则前驱节点为它的父节点
        return node.parent;
    }

    // 寻找某一节点的后继节点
    // 即中序遍历的后一个节点
    protected Node<E> successor(Node<E> node){
        if(node == null) return null;

        // 后继节点在右子树中
        Node<E> p = node.right;
        if(p != null)  {
            while(p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找后继节点
        while(node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        // 如果父节点为null 则后继节点为null
        // 如果当前节点为父节点的左节点，则后继节点为它的父节点
        return node.parent;
    }

    // 计算二叉树的高度(迭代)
    public int height(){
        if(root == null) return 0;

        int height = 0;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelSize--;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }

            // 访问下一层
            if(levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }
}
