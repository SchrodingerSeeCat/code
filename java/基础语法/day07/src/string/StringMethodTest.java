package string;

import org.junit.Test;

public class StringMethodTest {
    @Test
    public void test1(){
        String str = "Hello ";
        String str2 = "world";
        String str3 = "hello ";
        // 返回字符串的长度
        System.out.println(str.length());

        // 返回指定索引的字符
        System.out.println(str.charAt(1));

        // 判断当前字符串是否为空
        System.out.println(str.isEmpty());

        // 转换为小写
        System.out.println(str.toLowerCase());

        // 转换大写
        System.out.println(str.toUpperCase());

        // 除去空白字符
        System.out.println(str.trim());

        // 比较字符串的内容是否相同
        System.out.println(str.equals(str2));

        // 忽略大小写比较
        System.out.println(str.equalsIgnoreCase(str3));

        // 连接两个字符串
        System.out.println(str.concat(str2));

        // 比较两个字符串的大小
        System.out.println(str.compareTo(str2));

        // 截取子串
        System.out.println(str.substring(2));

        // 截取定长字符串
        System.out.println(str.substring(1, 3));

        // 判断此字符串是否以指定后缀结束
        System.out.println(str.endsWith(" "));

        // 判断此字符串是否以指定前缀开始
        System.out.println(str.startsWith("He"));

        // 判断某字符串是否包含另外一个字符串
        System.out.println(str.contains("ell"));
    }
}
