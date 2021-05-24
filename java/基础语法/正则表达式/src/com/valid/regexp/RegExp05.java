package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp05 {
    @Test
    @DisplayName("matches方法")
    public void test1() {
        String content = "Hello hello";
        System.out.println(Pattern.matches("Hello", content));
    }

    @Test
    @DisplayName("start&end")
    public void test2() {
        String content = "hello aa hello a";
        Pattern pattern = Pattern.compile("hello");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("start: " + matcher.start());
            System.out.println("end: " + matcher.end());
        }
        String s = matcher.replaceAll("hi");
        System.out.println(s);
    }
}
