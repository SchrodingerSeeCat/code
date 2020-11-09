package set;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* Set接口的框架
* */
public class SetTest {
    @Test
    public void test(){
        Set<Object> set = new HashSet<>();
        set.add(456);
        set.add("AA");
        set.add(LocalDateTime.now());
        set.add(new Person("Tom", 18));
        set.add(new Person("Tom", 18));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
