import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    // 比较器
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }
    public BinarySearchTree(){
        this(null);
    }
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

    // 判断元素是否存在二叉树中
    public boolean contains(E element) {
        return node(element) != null;
    }

    // 添加节点
    public void add(E element){
        elementNotNullCheck(element);
        // 添加第一节点
        if(root == null) {
            root = new Node<>(element, null);
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
        if (cmp > 0) {
            nodeParent.right = new Node<>(element, nodeParent);
        } else {
            nodeParent.left = new Node<>(element, nodeParent);
        }
        size++;
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

    // 计算二叉树的高度(递归)
//    public int height(){
//        return height(root);
//    }
//    private int height(Node<E> node){
//        if(node == null) return 0;
//        return Math.max(height(node.left), height(node.right)) + 1;
//    }

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

    // 判断是否是完全二叉树
//    public boolean isComplete(){
//        if(root == null) return false;
//
//        Queue<Node<E>> queue = new LinkedList<>();
//        queue.offer(root);
//        boolean leaf = false;
//        while(!queue.isEmpty()) {
//            Node<E> node = queue.poll();
//
//            if(leaf && !node.isLeaf()) {
//                return false;
//            }
//
//            // 叶子节点只会出现最后两层，且最后一层的叶子节点都靠左对齐
//            if(node.hasTwoChildren()) {
//                queue.offer(node.left);
//                queue.offer(node.right);
//            } else if(node.left == null && node.right != null) {
//                return false;
//            } else {
//                // 后面遍历的节点都必须是叶子节点
//                leaf = true;
//                if(node.left != null){
//                    queue.offer(node.left);
//                }
//            }
//        }
//        return true;
//    }
    // 前序遍历

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

    // 寻找某一节点的前驱节点
    // 即它中序遍历的前一个节点
    private Node<E> predecessor(Node<E> node){
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
    private Node<E> successor(Node<E> node){
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

    // 前序遍历
    public void preorderTraversal(){
        preorderTraversal(root);
    }
    private void preorderTraversal(Node<E> node){
        if(node == null) {
            return;
        }
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    // 中序遍历
    public void inorderTraversal(){
        inorderTraversal(root);
    }
    private void inorderTraversal(Node<E> node){
        if(node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    // 后序遍历
    public void postorderTraversal(){
        postorderTraversal(root);
    }
    private void postorderTraversal(Node<E> node){
        if(node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.element);
    }

    // 层次遍历
    public void levelOrderTraversal(){
        if(root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node<E> node = queue.poll();
            System.out.println(node.element);
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
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

    // 搜索树的节点
    private static class Node<E>{
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
    }
}
