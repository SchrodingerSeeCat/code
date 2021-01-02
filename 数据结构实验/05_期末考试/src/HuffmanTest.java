import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.function.Consumer;

public class HuffmanTest {
    public static void main(String[] args) {
        Huffman huffman = new Huffman(new int[]{5,29,7,8,14,23,3,11});
        System.out.println(huffman);
    }
}

class Huffman{
    private Node root;
    private ArrayList<NodeInfo> nodeInfos;

    public Huffman(int[] data) {
        if(data == null) return;

        // 初始化节点信息
        nodeInfos = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < data.length; i++) {
            nodeInfos.add(new NodeInfo(i + 1, data[i])); // 保存节点信息
            pq.add(new Node(data[i], null, null));
        }

        for(int i = 0; i < data.length - 1; i++) {
//            Node first = pq.remove();
//            Node second = pq.remove();
            Node first = pq.remove();
            Node second = pq.remove();

            // 生成父节点
            Node parent = new Node(first.element + second.element, first, second);
            // 保存父节点信息
            nodeInfos.add(new NodeInfo(nodeInfos.size() + 1, parent.element, find(first) + 1, find(second) + 1));

            // 设置子节点的父节点信息
            setInfo(first);
            setInfo(second);

            pq.add(parent);
        }
        root = pq.remove();
    }

    // 设置节点的信息
    private void setInfo(Node node) {
        nodeInfos.get(find(node)).parent = nodeInfos.size();
    }

    // 查找节点的索引
    private int find(Node node) {
        for(int i = 0; i < nodeInfos.size(); i++) {
            if(nodeInfos.get(i).weight == node.element) return i;
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return nodeInfos.toString();
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
    private static class NodeInfo{
        int i;  // 节点编号
        int weight; // 权值
        int parent; // 父节点
        int left; // 左孩子
        int right; // 右孩子

        public NodeInfo(int i, int weight) {
            this.i = i;
            this.weight = weight;
        }

        public NodeInfo(int i, int weight, int left, int right) {
            this(i, weight);
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "NodeInfo{" +
                    "i=" + i +
                    ", weight=" + weight +
                    ", parent=" + parent +
                    ", left=" + left +
                    ", right=" + right +
                    "}\n";
        }
    }
}

