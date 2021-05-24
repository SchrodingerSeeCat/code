package com.valid;

import com.valid.entity.Cat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    private static final String classpath;
    private static final String hi;
    static {
        // 根据res.properties的内容创建对象，并调用方法
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/res.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        classpath = (String)properties.get("classpath");
        hi = (String) properties.get("method");
        System.out.println(classpath + " " + hi);
    }
    @Test
    @DisplayName("反射引入")
    public void test1() throws Exception {
        // 获取Class
        Class<?> clazz = Class.forName(classpath);
        // 获取对象实例
        Object obj = clazz.getConstructor(String.class, Integer.class).newInstance("hahah", 10);
        // 获取方法
        Method method = clazz.getMethod(hi);
        // 调用方法
        method.invoke(obj); // hi hahah

        // 获取字段 不能获取私有的成员变量
        Field age = clazz.getField("age");
        System.out.println(age.get(obj));   // 10
    }

    @Test
    @DisplayName("性能测试")
    public void test2() throws Exception{
        // 获取Class
        Class<?> clazz = Class.forName(classpath);
        // 获取对象实例
        Object obj = clazz.getConstructor(String.class, Integer.class).newInstance("hahah", 10);
        // 获取方法
        Method method = clazz.getMethod(hi);
        method.setAccessible(true);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            method.invoke(obj); // hi hahah
        }
        System.out.println(System.currentTimeMillis() - begin);

        Cat cat = new Cat();
        begin = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            cat.hi(); // hi hahah
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
}
