package com.valid.Proxy.dynamicproxy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("动态代理")
    public void test() {
        // 创建目标对象
        ITeacherDao target = new TeacherDao();

        // 创建代理对象
        ProxyFactory proxy = new ProxyFactory(target);

        ITeacherDao proxyInstance = (ITeacherDao)proxy.getProxyInstance();
        proxyInstance.teach();
    }
}
