package constructor;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
* 方法引用
* */
public class ConstructorTest {
    @Test
    public void test() {
        Supplier<Person> sup = Person::new;
        Person p = sup.get();
        System.out.println(p);
    }

    @Test
    public void test1() {

        BiFunction<String, Integer, Person> bpd = Person::new;
        Person p = bpd.apply("Tom", 18);
        System.out.println(p);
    }

    @Test
    public void test2() {
        Function<Integer, String[]> func = String[]::new;
        String[] strs = func.apply(5);
        System.out.println(Arrays.toString(strs));
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}