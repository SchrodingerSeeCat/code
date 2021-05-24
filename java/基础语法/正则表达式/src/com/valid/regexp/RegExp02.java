package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp02 {
    String content = "ab12$a(ab123($";

    @Test
    @DisplayName("转义字符")
    public void test() {
        Pattern pattern = Pattern.compile("\\(");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("大小写不敏感")
    public void test2() {
        Pattern pattern = Pattern.compile("(?i)AB");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("选择匹配")
    public void test3() {
        Pattern pattern = Pattern.compile("a|b");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("定位符")
    public void test4() {
        Pattern pattern = Pattern.compile("^a");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    @DisplayName("命名分组")
    public void test5() {
        Pattern pattern = Pattern.compile("(?<g1>\\d\\d)(?<g2>\\d)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.print(matcher.group("g1") + " ");
            System.out.println(matcher.group("g2"));
        }
    }
}
