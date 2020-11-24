import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Huffman<E> {
    private Node<E> root;

    public Huffman(){}
    public Huffman(Heap<Node<E>> heap) {
        createHuffman(heap, heap.size());
    }
    private void createHuffman(Heap<Node<E>> heap, int len) {
        for(int i = 0; i < len - 1; i++) {
            Node<E> temp = new Node<>(heap.remove(), heap.remove());
            heap.add(temp);
        }
        root = heap.remove();
    }

    // 前序遍历
    public void preOrder(Node<E> node, Consumer<Node<E>> con) {
        if (node == null || con == null) return;
        con.accept(node);
        preOrder(node.getLeft(), con);
        preOrder(node.getRight(), con);
    }
    public void preOrder(Node<E> node, BiConsumer<Node<E>, StringBuffer> con, StringBuffer sb) {
        if (node == null) return;
        con.accept(node, sb);
        preOrder(node.getLeft(), con, sb.append(0));
        preOrder(node.getRight(), con, sb.append(1));
    }

    // 求最优前缀码
    public void besPrefix() {
//        bestPrefix(root);
        preOrder(root, new StringBuffer());
    }
    public void preOrder(Node<E> node, StringBuffer sb) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println(node + sb.toString());
            sb.delete(0, sb.length());
        }
        preOrder(node.getLeft(), sb.append(0));
        preOrder(node.getRight(), sb.append(1));
    }
    private void bestPrefix(Node<E> node) {
        preOrder(node, (n, sb) -> {
            if(n.getLeft() == null && n.getRight() == null) {
                System.out.println(node + sb.toString());
            }
        }, new StringBuffer());
    }

    @Override
    public String toString() {
        preOrder(root, System.out::print);
        return "";
    }
}

class Node<E> implements Comparable<Node<E>>{
    private E element;
    private float frequency;
    private Node<E> left;
    private Node<E> right;

    public Node(Node<E> left, Node<E> right) {
        this.left = left;
        this.right = right;
        this.frequency = left.frequency + right.frequency;
    }
    public Node(E element, float frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    @Override
    public int compareTo(Node node) {
        return (int) (this.frequency - node.frequency);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.
                append('(').
                append(element).
                append(", ").
                append(frequency).
                append(')').
                toString();
    }
}
