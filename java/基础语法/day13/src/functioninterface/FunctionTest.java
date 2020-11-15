package functioninterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
* java 内置的4大核心函数式接口
* 消费型接口 Consumer<T> void accept(T t)
* 供给型接口 Supplier<T> T get()
* 函数型接口 Function<T, R> R apply(T t)
* 断定型接口 Predicate<T> boolean test(T t)
* */
public class FunctionTest {
    @Test
    public void test() {
        happyTime(500, t -> {
            System.out.println("我有" + t + "元");
        });
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test1() {
        // 筛选出所有含 京 的字符串
        List<String> list = Arrays.asList("北京", "上海", "南京","广州", "深圳");

        List<String> list1 = filterString(list, str -> str.endsWith("京"));
        System.out.println(list1);
    }
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
