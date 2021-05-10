package com.valid.composite;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("测试组合模式")
    public void test() {
        // 创建学校
        OrganizationComponent university = new University("清华大学", "中国顶尖院校");

        // 触感见学院
        OrganizationComponent college1 = new College("计算机学院", "计算机学院");
        OrganizationComponent college2 = new College("信息工程学院", "信息工程学院");

        // 创建专业
        college1.add(new Department("软件工程", "软件工程不错"));
        college1.add(new Department("网络工程", "网络工程不错"));
        college1.add(new Department("计算机科学与技术", "计算机科学与技术不错"));
        college2.add(new Department("网络安全", "网络安全"));
        college2.add(new Department("通信工程", "通信工程不过好学"));

        // 将学院加入到学校中
        university.add(college1);
        university.add(college2);

        university.print();
    }
}
