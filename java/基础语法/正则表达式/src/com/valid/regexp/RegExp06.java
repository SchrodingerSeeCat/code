package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 反向引用
public class RegExp06 {

    @Test
    @DisplayName("匹配连续相同的数字")
    public void test1() {
        String content = "hello tom11 jack22";
        Pattern pattern = Pattern.compile("(\\d)\\1");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    @Test
    @DisplayName("去重")
    public void test2() {
        String content = "我....我要....学学学学....编程java";
        Pattern pattern = Pattern.compile("\\."); // 消除...
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");

        pattern = Pattern.compile("(.)\\1+"); // 匹配重复字符
        matcher = pattern.matcher(content);
        content = matcher.replaceAll("$1"); // 消除重复字符
        System.out.println(content);
    }
}
