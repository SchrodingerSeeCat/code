package list;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListTest {
    @Test
    public void test(){
        ArrayList<Object> list = new ArrayList();
        list.add(123);
        list.add("ert");

        // 插入指定索引位置
//        list.add(1, LocalDateTime.now());
//        System.out.println(list);

        // 添加一个集合
//        List<Object> tempList = Arrays.asList(1, 2, 3);
//        list.addAll(1, tempList);
//        System.out.println(list);

        // 获取指定索引位置的元素
//        System.out.println(list.get(1));

        // 返回指定元素在集合中首次出现的位置
//        System.out.println(list.indexOf("ert"));

        // 移除指定索引位置的元素
//        list.remove(1);
//        System.out.println(list);

        // 修改指定位置的元素
        list.set(0, LocalDateTime.now());
        System.out.println(list);
    }
}
