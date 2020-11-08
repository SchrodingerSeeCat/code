package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
* 集合元素的遍历操作，使用Iterator
* */
public class IteratorTest {
    @Test
    public void test(){
        Collection<Object> coll = new ArrayList<>();
        coll.add("qwer");
        coll.add(123);
        coll.add(false);

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
