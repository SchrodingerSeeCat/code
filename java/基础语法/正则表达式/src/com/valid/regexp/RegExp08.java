package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp08 {
    @Test
    @DisplayName("匹配邮箱")
    public void test1() {
        String content = "5asdf@sohu.com";
        System.out.println(Pattern.matches("^[\\w-]+@([\\w]+\\.)+[a-z]+$", content));
    }

    @Test
    @DisplayName("验证数字")
    public void test2() {
        String content = "+0.0";
        System.out.println(Pattern.matches("^[-+]?([1-9]\\d*|0)(\\.\\d+)?$", content));
    }

    @Test
    @DisplayName("解析URL")
    public void test3() {
        String content = "https://www.runoob.com:8080/abc/sss/xxx/index.html";
        Pattern pattern = Pattern.compile("^https?://((?:www\\.)?(?:[a-z]+\\.)+[a-z]+)(?::(\\d{1,5}))?/(?:[0-9a-z%#_]+/)*(\\S+)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配的URL " + matcher.group());
            System.out.println("域名 " + matcher.group(1));
            System.out.println("端口 " + matcher.group(2));
            System.out.println("文件 " + matcher.group(3));
        }
    }
}
