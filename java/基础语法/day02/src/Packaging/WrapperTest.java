package Packaging;

public class WrapperTest {
    public static void main(String[] args) {
//        int num = 1;
//        Integer n1 = new Integer(num);
//        Integer n2 = new Integer("123");
//
//        // 自动装箱
//        Integer n3 = num;
//        int n = n1.intValue();
//        method(10);
//
//        // 自动拆箱
//        int n4 = n3;

        // 基本数据类型、包装类 ----> String类型
//        int num = 10;
//        String str = num + "";
//
//        // 方式二
//        String str2 = String.valueOf(num);

        // String类型 ---> 基本数据类型、包装类：调用包装类的 parseXxx(String s)
        int num = Integer.parseInt("123");
    }
    public static void method(Object obj) {
        System.out.println(obj);
    }
}
