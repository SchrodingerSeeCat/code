package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp03 {
    String content = "abcd abfg abdd";

    @Test
    @DisplayName("匹配非捕获中的内容")
    public void test1() {
        Pattern pattern = Pattern.compile("ab(?:cd|fg|dd)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("不捕获(里的内容")
    public void test2() {
        Pattern pattern = Pattern.compile("ab(?=cd|fg|dd)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("第三种情况")
    public void test3() {
        Pattern pattern = Pattern.compile("ab(?!cd|fg)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
