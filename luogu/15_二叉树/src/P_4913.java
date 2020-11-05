import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P_4913 {
    public static BinaryTree root;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        root = new BinaryTree(1);
        int n = reader.nextInt();
        BinaryTree temp = root;
        for(int i = 0; i < n; i++){
            int left = reader.nextInt();
            int right = reader.nextInt();

            if(left == 0 && right == 0) continue;

            temp.left = new BinaryTree(left);
            temp.right = new BinaryTree(right);
        }
    }
    public static void add(int left, int right){

    }
    public static int deep(BinaryTree root){
        if (root == null) return 0;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            BinaryTree node = queue.poll();

            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return 0;
    }
    private static class BinaryTree {
        int element;
        BinaryTree left;
        BinaryTree right;
        public BinaryTree(int element){
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
}
