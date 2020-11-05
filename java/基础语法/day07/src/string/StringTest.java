package string;
/*
* String的使用
* */
public class StringTest {
    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2); // true
        str2 = "hello";
        System.out.println(str1 == str2); // false
    }
    public static void test2(){
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1 == str2); // false
    }
    public static void test3(){
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = "hello" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        // 返回值得到的s8使用常量池中已经存在的"helloworld"
        String s8 = s5.intern();
        System.out.println(s3 == s8); //true
    }

}
