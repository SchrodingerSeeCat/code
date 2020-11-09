package set;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test(){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(99);
        set.add(34);
        set.add(1024);
        set.add(0);
        System.out.print(set + " ");
    }

    @Test
    public void test1(){
        TreeSet<User> set = new TreeSet<>();
        set.add(new User("Tom", 18));
        set.add(new User("Bob", 28));
        set.add(new User("Jack", 18));
        set.add(new User("Jack", 58));
        set.add(new User("Alice", 78));
        System.out.println(set);
    }
    @Test
    public void test2(){
        TreeSet<User> set = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = -o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
        set.add(new User("Tom", 18));
        set.add(new User("Bob", 28));
        set.add(new User("Jack", 18));
        set.add(new User("Jack", 58));
        set.add(new User("Alice", 78));
        System.out.println(set);
    }
}

class User implements Comparable{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User)o;
            return this.name.compareTo(user.name);
        }
        throw new ClassCastException("类型不匹配");
    }
}
