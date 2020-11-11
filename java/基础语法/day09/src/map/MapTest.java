package map;
import org.junit.Test;
import set.Person;

import java.time.LocalDateTime;
import java.util.*;

public class MapTest {
    @Test
    public void test(){
        Map<Object, Object> map = new HashMap<>();
        // 添加
//        map.put(123, "AA");
//        map.put("BB", 456);
//
//        // 修改
//        map.put(123, "CC");
//        System.out.println(map);

//        map.put("移除", 123);
//        System.out.println(map);
//        System.out.println(map.remove("移除"));
//        System.out.println(map);

        // 获取指定key对应的value
//        map.put(123, "Hello World");
//        System.out.println(map.get(123));

        // 判断是否包含某个key
//        map.put(123, "Hello World");
//        System.out.println(map.containsKey(123));

        // 返回key-value的个数
//        System.out.println(map.size());

        // 判断当前map是否为空
//        System.out.println(map.isEmpty());

        System.out.println(map.equals(map));
    }

    @Test
    public void test1(){
        Map<Object, Object> map = new HashMap<>();

        map.put(123, "AA");
        map.put("BB", 456);
        map.put("456", 999);
        map.put("NowTime", LocalDateTime.now());
        Set set =  map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Collection coll =  map.values();
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        // 遍历key-value
        Set entrySet = map.entrySet();
        Iterator iterator2 = entrySet.iterator();
        while(iterator2.hasNext()) {
            Object obj = iterator2.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
