import org.junit.Test;
import tree.RBTree;

public class Main {
    @Test
    public void test() {
        Integer data[] = new Integer[] {
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };
        RBTree<Integer> rb = new RBTree<>(Integer::compare);
        for(int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        System.out.println(rb);
    }
}
