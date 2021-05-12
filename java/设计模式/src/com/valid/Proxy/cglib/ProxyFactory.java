package com.valid.Proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {
    private final Object target; // 被代理对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();         //1. 创建一个工具类
        enhancer.setSuperclass(target.getClass());  // 2. 设置父类
        enhancer.setCallback(this);                 // 3. 设置回调函数
        return enhancer.create();                   // 4.创建代理对象
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理开始...");
        Object result = method.invoke(target, args);
        System.out.println("代理结束...");
        return result;
    }
}
