package endoperation;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EndOperationTest {
    // 匹配与查找
    @Test
    public void test() {
        List<Person> list = Person.getPersons();
        boolean flag = list.stream().allMatch(person -> person.getAge() > 18);
        System.out.println(flag);
        System.out.println();

        Optional<Person> p = list.stream().findFirst();
        System.out.println(p);
        System.out.println();

        Optional<Integer> age = list.stream().map(person -> person.getAge()).max(Integer::compare);
        System.out.println(age);
    }

    // 归约
    @Test
    public void test1() {
        // 计算1-100的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(10, Integer::sum);
        System.out.println(sum);

        // 计算所有人的年龄总和
        List<Person> person = Person.getPersons();
        Optional<Integer> sum1 = person.stream().map(Person::getAge).reduce(Integer::sum);
        System.out.println(sum1);
    }

    // 收集
    @Test
    public void test2() {
        List<Person> person = Person.getPersons();
        // 查找年龄大于20的，结果返回一个List或Set
        List<Person> list = person.stream().filter(p -> p.getAge() > 18).collect(Collectors.toList());
        System.out.println(list);
    }
}
