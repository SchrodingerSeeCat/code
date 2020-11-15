package methodreferences;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
* 方法引用
 */
public class MethodTest {
    @Test
    public void test() {
        Consumer<String> con = System.out::println;
        con.accept("北京");
    }

    @Test
    public void test1() {
        MethodTest methodTest = new MethodTest();
        Supplier<String> sup = methodTest::print;
        System.out.println(sup.get());
    }
    public String print() {
        return "hello";
    }

    @Test
    public void test2() {
        Comparator<Integer> com = Integer::compare;
        System.out.println(com.compare(12, 3));
    }

    @Test
    public void test3() {
        Comparator<Integer> com = Integer::compareTo;
        System.out.println(com.compare(15, 10));
    }
}


