package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 快速上手
public class RegexpTest {
    private final static String content = "Java是一门面向对象编程语言，" +
            "不仅吸收了C++语言的各种优点，还摒弃了C++" +
            "里难以理解的多继承、指针等概念，因此Java语" +
            "言具有功能强大和简单易用两个特征。Java语言" +
            "作为静态面向对象编程语言的代表，极好地实现了" +
            "面向对象理论，允许程序员以优雅的思维方式进行" +
            "复杂的编程";
    @Test
    @DisplayName("快速上手")
    public void test1() {
        // 1. 创建一个Pattern对象,模式对象,可以理解成就是一个正则表达式对象
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        // 2. 创建一个匹配器对象
        Matcher matcher = pattern.matcher(content);
        // 3.开始循环匹配
        while(matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }
}
