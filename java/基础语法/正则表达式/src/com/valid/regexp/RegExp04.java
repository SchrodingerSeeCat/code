package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 正则练习
public class RegExp04 {
    @Test
    @DisplayName("汉字")
    public void test1() {
        String content = "abc中国123";
        Pattern pattern = Pattern.compile("[\\u0391-\\uffe5]+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("邮政编码")
    public void test2() {
        String content = "123456";
        Pattern pattern = Pattern.compile("^[1-9]{5}\\d$");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("手机号码")
    public void test3() {
        String content = "13153678901";
        Pattern pattern = Pattern.compile("^(?:13|14|15)[0-9]{9}$");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("验证URL")
    public void test4() {
        String content = "https://www.bilibili.com/video/BV1fh411y7R8";
        Pattern pattern = Pattern.compile("^https?://(www\\.)?[\\w-]+\\.[a-zA-Z\\u0391-\\uffe5]+/");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
