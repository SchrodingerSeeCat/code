import org.junit.Test;
import tree.AVLTree;

public class Main {
    @Test
    public void test() {
        // 测试添加数据之后的调整
        Integer data[] = new Integer[] {85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56};
        AVLTree<Integer> avl = new AVLTree<>(Integer::compare);
        for(int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }
        System.out.println(avl);
    }

    @Test
    public void test1() {
        // 测试删除数据之后的修改
        Integer data[] = new Integer[] {85, 19, 69, 3, 7, 99, 95};
        AVLTree<Integer> avl = new AVLTree<>(Integer::compare);
        for(int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }
        System.out.println(avl);
        System.out.println("-----------------------");
        avl.remove(99);
        avl.remove(85);
        avl.remove(95);
        System.out.println(avl);
    }
}
