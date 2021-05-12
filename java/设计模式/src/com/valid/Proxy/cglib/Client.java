package com.valid.Proxy.cglib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("Cglib代理")
    public void test() {
        // 创建目标对象
        TeacherDao teacherDao = new TeacherDao();

        // 创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);

        // 获取代理对象
        TeacherDao instance = (TeacherDao)proxyFactory.getProxyInstance();
        instance.teach();
    }
}
