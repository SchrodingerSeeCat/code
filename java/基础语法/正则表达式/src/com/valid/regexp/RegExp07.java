package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegExp07 {
    @Test
    @DisplayName("替换")
    public void test1() {
        String content = "JDK1.8和JDK11是两个长期支持版";
        content = content.replaceAll("(JDK)1(?:\\.8|1)", "$1");
        System.out.println(content);
    }

    @Test
    @DisplayName("分割")
    public void test2() {
        // 按照#或者-或者~或者数字来分割
        String content = "hello#abc-hha~jack1tom";
        String[] split = content.split("#|-|~|\\d+");
        for (String str : split) {
            System.out.println(str);
        }
    }
}
