package string;

import org.junit.Test;

import java.util.Arrays;

public class StringConversion {
    @Test
    public void test1() {
        // String 转基本数据类型包装类
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);
    }
    @Test
    public void test2(){
        // 基本数据类型转String
        int num = 123;
        String str1 = String.valueOf(num);
        String str2 = num + "";

        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void test3(){
        // String --> char[]之间的转换
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            System.out.print(charArray[i]);
        }
    }

    @Test
    public void test4(){
        // char[] --> String
        char[] charArray = {'1', 'a', 'c'};
        String str = new String(charArray);
        System.out.println(str);
    }

    @Test
    public void test5(){
        // String --> byte[]
        String str = "abc123";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test6(){
        // byte[] --> String
        byte[] bytes = {97, 98, 99, 49, 50, 51};
        String str = new String(bytes);
        System.out.println(str);
    }
}
