package com.valid.Proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    // 维护一个目标对象
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 给目标对象生成代理对象
    public Object getProxyInstance() {
        // loader 指定当前目标对象使用的类加载器
        // interfaces 目标对象实现的接口类型, 使用泛型的方法确认类型
        // h 事件处理, 执行目标对象的方法时, 会触发事件处理方法，会把当前执行的目标对象的方法作为参数传入
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                      target.getClass().getInterfaces(),
                                      new InvocationHandler() {
                                          @Override
                                          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                              System.out.println("JDK代理开始");
                                              Object result = method.invoke(target, args);
                                              System.out.println("JDK代理结束");
                                              return result;
                                          }
                                      });
    }
}
