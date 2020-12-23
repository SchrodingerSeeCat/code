import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.Consumer;

public class HuffmanTest {
    public static void main(String[] args) {
        Huffman huffman = new Huffman(new int[]{5,29,7,8,14,23,3,11});
        huffman.preOrder();
    }
}

class Huffman{
    private Node root;

    public Huffman(int[] data) {
        if(data == null) return;

        // ≈≈–Ú
        Arrays.sort(data);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < data.length; i++) {
            pq.add(new Node(data[i], null, null));
        }

        for(int i = 0; i < data.length - 1; i++) {
            Node first = pq.remove();
            Node second = pq.remove();
            pq.add(new Node(first.element + second.element, first, second));
        }
        root = pq.remove();
    }

    // œ»–Ú±È¿˙
    public void preOrder() {
        preOrder(root, node -> {
            System.out.print(node.element + " ");
        });
    }
    private void preOrder(Node node, Consumer<Node> con) {
        if(node == null) return;
        con.accept(node);

        preOrder(node.left, con);
        preOrder(node.right, con);
    }

    private static class Node implements Comparable<Node>{
        private int element;
        private Node left;
        private Node right;

        public Node(int element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node node) {
            return this.element - node.element;
        }
    }
}
