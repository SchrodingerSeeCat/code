package practice;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    @Test
    public void test(){
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.compare(o2);
            }
        });
        MyDate birthday1 = new MyDate(1999, 1, 31);
        MyDate birthday2 = new MyDate(1997, 3, 31);
        MyDate birthday3 = new MyDate(1999, 2, 31);
        MyDate birthday4 = new MyDate(1999, 1, 29);
        MyDate birthday5 = new MyDate(2000, 1, 29);
        set.add(new Employee("Tom", 12, birthday1));
        set.add(new Employee("Alice", 12, birthday2));
        set.add(new Employee("Jack", 12, birthday3));
        set.add(new Employee("Bob", 12, birthday4));
        set.add(new Employee("Tom", 12, birthday5));

        set.forEach(System.out::println);
    }
}
