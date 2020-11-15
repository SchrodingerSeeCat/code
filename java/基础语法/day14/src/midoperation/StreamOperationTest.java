package midoperation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperationTest {
    // 筛选与切片
    @Test
    public void test() {
        List<Person> persons = Person.getPersons();
        Stream<Person> stream = persons.stream();

        // 筛选年龄大于18的人
        stream.filter(person -> person.getAge() > 20).forEach(System.out::println);
        System.out.println();

        // 取流的前三条记录
        stream = persons.stream();
        stream.limit(3).forEach(System.out::println);
        System.out.println();

        // 跳过流的前三条记录
        stream = persons.stream();
        stream.skip(3).forEach(System.out::println);
        System.out.println();
    }

    // 映射
    @Test
    public void test1() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        // 数组元素变大写
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        System.out.println();

        // 获取员工姓名等于4的姓名
        List<Person> p = Person.getPersons();
        p.stream().map(Person::getName).filter(name -> name.length() == 4).forEach(System.out::println);
        System.out.println();

        // flatMap
        list.stream().flatMap(StreamOperationTest::fromStringToStream).forEach(c -> {
            System.out.print(c + " ");
        });
    }

    // 将对应字符串中的多个字符构成的集合转化为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }


    // 排序
    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 8, 0, 6, 7, 10, 12, 4);
        list.stream().sorted().forEach(num ->{
            System.out.print(num + " ");
        });
        System.out.println();
        list.stream().sorted((o1, o2) -> - o1.compareTo(o2)).forEach(num ->{
            System.out.print(num + " ");
        });
    }
}
