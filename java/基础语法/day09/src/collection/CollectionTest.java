package collection;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
    @Test
    public void test(){
        Collection<Object> coll = new ArrayList<>();

        // 添加
        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(LocalDateTime.now());

        // 获取大小
        System.out.println(coll.size());
        System.out.println(coll);

        // 判断是否集合是否为空
        System.out.println(coll.isEmpty());

        // 清空集合元素
//        coll.clear();
//        System.out.println(coll);

        // contains(Object obj)判断当前集合中是否包含obj
        System.out.println(coll.contains(123));

        // 计算集合的哈希值
        System.out.println(coll.hashCode());

        // 集合转换为数组
        Object[] arr = coll.toArray();
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        // 数组转换为集合
        List<String> list =  Arrays.asList(new String[]{"QQ", "UU", "中国"});

    }
}
