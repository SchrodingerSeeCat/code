package compare;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
* Java中的对象，正常情况下，只能进行比较 == 或 != 不能使用 > 或者 <
*
* */
public class CompareTest {
    @Test
    public void test1(){
        // String 包装类已经实现了Comparable接口
        String[] arr = new String[]{"AA", "BB", "PP", "GG", "CC"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("小米", 99.9);
        arr[1] = new Goods("雷蛇", 299.9);
        arr[2] = new Goods("HP", 19.9);
        arr[3] = new Goods("戴尔", 199.9);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3(){
        // Comparator字符串从大到小排序
        String[] arr = new String[]{"AA", "BB", "PP", "GG", "CC"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}

// 实现Comparable接口
class Goods implements Comparable{
    private String name;
    private double price;
    public Goods(String name, double price){
        this.name = name;
        this.price = price;
    }

//
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods)o;
            return (int)(this.price - goods.price);
        }
        throw new ClassCastException("类型错误");
    }
}

