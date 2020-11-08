package collection;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class ForEach {

    @Test
    public void test(){
        Collection<Object> coll = new ArrayList<>();
        coll.add(123);
        coll.add("ggghh");
        coll.add(LocalDateTime.now());

        for(Object value: coll) {
            System.out.println(value);
        }
    }
}
