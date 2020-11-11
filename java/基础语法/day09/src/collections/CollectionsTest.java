package collections;

import org.junit.Test;

import java.util.*;

public class CollectionsTest {
    @Test
    public void test(){
        List<Integer> list = new LinkedList<>();
        list.add(123);
        list.add(456);
        list.add(0);
        list.add(23);
        list.add(100);
        System.out.println(list);

        // 反转
//        Collections.reverse(list);
//        System.out.println(list);

        // 随机排序
//        Collections.shuffle(list);
//        System.out.println(list);

        // 排序
//        Collections.sort(list);
//        System.out.println(list);

//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        System.out.println(list);



        // 交换
//        Collections.swap(list, 0, 1);
//        System.out.println(list);

        // 元素出现的频率
//        System.out.println(Collections.frequency(list, 0));
//
//        List<Integer> dest = Arrays.asList(new Integer[list.size()]);
//        Collections.copy(dest, list);
//        System.out.println(dest);



        // 同步控制
        List syncList = Collections.synchronizedList(list);
    }
}
