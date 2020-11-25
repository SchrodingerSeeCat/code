import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Heap<Node<Character>> heap = new Heap<>(n, false);
        for(int i = 0; i < n; i++) {
            heap.add(new Node(reader.next(), reader.nextFloat()));
        }
        Huffman<Character> huffman = new Huffman<>(heap);
        huffman.bestPrefix();
    }
}
