package lambdatest;

import org.junit.Test;
import java.util.Comparator;
import java.util.function.Consumer;

/*
*
* Lambda表达式
* */
public class LambdaTest {
    @Test
    public void test() {
        // 无参，无返回值
        Runnable r = () -> System.out.println("I am a iron man");
        r.run();
    }

    @Test
    public void test1() {
        // 需要两个或以上的参数，多条执行语句，并且可以有有返回值
        Comparator<Integer> com = (o1, o2) -> {
            return Integer.compare(o1, o2);
        };

        System.out.println(com.compare(23, 32));
    }

    @Test
    public void test2() {
        // 有一个参数，没有返回值
        Consumer<String> c = (String str) -> {
            System.out.println("有一个参数，没有返回值\t" + str);
        };
        c.accept("被调用了");
    }

    @Test
    public void test3() {

    }
}

@FunctionalInterface
interface MyInterface{
    void method();
}