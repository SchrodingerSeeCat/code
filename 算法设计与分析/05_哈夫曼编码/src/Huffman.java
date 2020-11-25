public class Huffman<E> {
    private Node<E> root;

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

    public void bestPrefix(){
        StringBuffer sb = new StringBuffer();
        Sum sum = new Sum();
        bestPrefix(root, sb, "", sum);
        System.out.print(sb + sum.toString());
    }
    private void bestPrefix(Node<E> node, StringBuffer sb, String prefix, Sum sum){
        if(node == null) return;
        if(node.getLeft() == null && node.getRight() == null) {
            sb.append(node.getElement()).append(": ").append(prefix).append("\n");
            sum.acc(prefix.length() * (int)node.getFrequency());
        }
        bestPrefix(node.getLeft(), sb, prefix + "0", sum);
        bestPrefix(node.getRight(), sb, prefix + "1", sum);
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

    public E getElement() {
        return element;
    }

    public float getFrequency() {
        return frequency;
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

class Sum{
    private int sum;
    public void acc(int element) {
        sum += element;
    }

    @Override
    public String toString() {
        return sum + "";
    }
}
