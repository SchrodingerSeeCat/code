import java.util.Scanner;
import java.util.function.Supplier;

public class BinaryTree {
    private Node root;
    public void createTree() {
        preOrder(root, () -> {
            Scanner reader = new Scanner(System.in);
            Character ch = reader.next().charAt(0);
            reader.close();
            return ch;
        });
    }
    public void preOrder(Node node, Supplier<Character> fun) {
        char ch = fun.get();
        if (ch == '#') return;
        node = new Node(ch);
        preOrder(node.left, fun);
        preOrder(node.right, fun);
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
