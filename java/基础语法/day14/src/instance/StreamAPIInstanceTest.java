package instance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
* Stream API的实例化
* */
public class StreamAPIInstanceTest {
    // 方式一集合
    @Test
    public void test() {
        List<Person> persons = Person.getPersons();
        // 返回一个顺序流
        Stream<Person> stream = persons.stream();
        // 返回一个并行流
        Stream<Person> personStream = persons.parallelStream();
    }

    // 方式二数组
    @Test
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream stream = Arrays.stream(arr);
    }

    // 方式三Stream的of()方法
    @Test
    public void test2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    // 方式四：创建无限流
    @Test
    public void test3() {
        // 迭代
        // Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        // 生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
class Person{
    private String name;
    private int age;

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static List<Person> getPersons(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Tom", 18));
        list.add(new Person("Jack", 56));
        list.add(new Person("Alice", 18));
        list.add(new Person("Bob", 38));
        list.add(new Person("Tony", 22));
        list.add(new Person("Stark", 14));
        return list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}