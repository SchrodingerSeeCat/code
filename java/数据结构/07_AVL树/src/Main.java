import java.util.Comparator;

import org.junit.Test;
import tree.AVLTree;
import tree.BinarySearchTree;

public class Main {
    @Test
    public void test() {
        Integer data[] = new Integer[] {7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        AVLTree<Integer> avl = new AVLTree<>(Integer::compare);
        for(int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }
    }
}
