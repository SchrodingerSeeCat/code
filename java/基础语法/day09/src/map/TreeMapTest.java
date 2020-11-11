package map;

import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    @Test
    public void test(){
        Map<User, Integer> map = new TreeMap<>();
        map.put(new User("Tom", 23), 98);
        map.put(new User("Bob", 15), 100);
        map.put(new User("Jack", 34), 90);
        map.put(new User("Alice", 22), 91);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    public void test2(){
        Map<User, Integer> map = new TreeMap<>(new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                int result = o1.name.compareTo(o2.name);
                if (result == 0) {
                    result = o1.age - o2.age;
                }
                return  -result;
            }
        });
        map.put(new User("Tom", 23), 98);
        map.put(new User("Bob", 15), 100);
        map.put(new User("Jack", 34), 90);
        map.put(new User("Alice", 22), 91);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
class User implements Comparable{
    String name;
    int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            int result = this.name.compareTo(user.name);
            if (result == 0) {
                result = this.age - user.age;
            }
            return  result;
        }
        throw new ClassCastException("类型转换错误");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

