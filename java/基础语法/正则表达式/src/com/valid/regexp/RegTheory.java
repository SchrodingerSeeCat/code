package com.valid.regexp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 底层原理
public class RegTheory {
    private final static String content = "1998年12月8日，第二代Java平台" +
            "的企业版J2EE发布。1999年6月，Sun公司发布了第二代Java平台" +
            "（简称为Java2）的3个版本：J2ME（Java2 Micro Edition，Jav" +
            "a2平台的微型版），应用于移动、无线及有限资源的环境；J2SE（Java " +
            "2 Standard Edition，Java 2平台的标准版），应用于桌面环境；J" +
            "2EE（Java 2Enterprise Edition，Java 2平台的企业版），应用" +
            "于基于Java的应用服务器。Java 2平台的发布，是Java发展过程中最重" +
            "要的一个里程碑，标志着Java的应用开始普及。";

    @Test
    @DisplayName("匹配四个连续数字")
    public void test1() {
        // 1. 创建模式对象
        Pattern pattern = Pattern.compile("(\\d\\d)(\\d\\d)");
        // 2. 按照模式对象的规则创建匹配器
        Matcher matcher = pattern.matcher(content);
        // 3. 开始匹配
        while(matcher.find()) {
            System.out.println("原始串: " + matcher.group(0) + " ");
            System.out.println("\t第一组: " + matcher.group(1) + " ");
            System.out.println("\t第二组: " + matcher.group(2) + " ");
        }
    }
}
