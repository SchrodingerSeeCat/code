public class Main {
    public static void main(String[] args) {
        Huffman<Integer> huffman = new Huffman<>(add());
        huffman.besPrefix();
//        System.out.println(huffman);
    }

    public static Heap<Node<Integer>> add() {
        Node<Integer>[] nodes = new Node[]{
                new Node<>(0, 5),
                new Node<>(1, 5),
                new Node<>(2, 10),
                new Node<>(3, 15),
                new Node<>(4, 25),
                new Node<>(5, 10),
                new Node<>(6, 10),
                new Node<>(7, 20)
        };
        Heap<Node<Integer>> heap = new Heap<>(nodes.length);
        for(int i = 0; i < nodes.length; i++) {
            heap.add(nodes[i]);
        }
        return heap;
    }
}
