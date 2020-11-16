public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.generateTree("ABC##DE#G##F###");
        binaryTree.inOrder();
        binaryTree.lastOrder();
        // "ABC##DE#G##F###"
    }
}
