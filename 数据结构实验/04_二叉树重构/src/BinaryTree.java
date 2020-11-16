import java.util.*;

public class BinaryTree {
    private Node root;
    public void generateTree(String tree) {
        List<Character> list = new LinkedList<>();
        for(int i = 0; i < tree.length(); i++) {
            list.add(tree.charAt(i));
        }
        Iterator<Character> iterator = list.iterator();

        preOrder(root, iterator);
    }
    public void preOrder(Node node, Iterator<Character> iterator) {
        char temp = iterator.next();
        if (temp == '#') return;
        node = new Node(temp);
        preOrder(node.left, iterator);
        preOrder(node.right, iterator);
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    // 后序遍历
    public void lastOrder(){
        lastOrder(root);
    }
    private void lastOrder(Node node) {
        if (node == null) return;
        lastOrder(node.left);
        System.out.println(node.element);
        lastOrder(node.right);
    }
    private static class Node {
        private char element;
        private Node left;
        private Node right;
        public Node(char element) {
            this.element = element;
        }
    }
}
