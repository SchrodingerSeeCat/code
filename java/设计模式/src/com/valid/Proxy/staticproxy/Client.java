package com.valid.Proxy.staticproxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("静态代理")
    public void test() {
        // 被代理对象
        TeacherDao teacherDao = new TeacherDao();

        // 代理对象
        TeacherDaoProxy proxy = new TeacherDaoProxy(teacherDao);

        // 通过代理对象，调用到被代理对象的方法
        proxy.teach();
    }
}
