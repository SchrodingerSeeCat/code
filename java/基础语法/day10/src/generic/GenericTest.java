package generic;

import org.junit.Test;

import java.util.*;

public class GenericTest {
    @Test
    public void test(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);

        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    @Test
    public void test1() {
        List<Object> list1 = new ArrayList<>();
        list1.add(123);
        list1.add("rty");

        List<String> list2 = new LinkedList<>();
        list2.add("uio");
        list2.add("asd");

        List<?> list = null;
        list = list1;
        list = list2;

        print(list1);
        print(list2);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test3(){
        List<? extends Animal> list1 = new LinkedList<>();
        List<? super Animal> list2 = new LinkedList<>();

        List<Animal> list3 = new LinkedList<>();
        List<Dog> list4 = new LinkedList<>();
        List<Object> list5 = new LinkedList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

        list2 = list3;
//        list2 = list4;
        list2 = list5;
    }


}

class Animal{

}

class Dog extends Animal{

}