package com.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URL;

public class ClassLoaderTest {
    @Test
    @DisplayName("演示类加载器")
    public void test() {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); // jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc

        // 获取系统类加载器的上层，扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader); // jdk.internal.loader.ClassLoaders$PlatformClassLoader@7c30a502

        // 获取扩展类加载器的上层，引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader); // null

        // 对于用户自定义类来说，默认使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); // jdk.internal.loader.ClassLoaders$AppClassLoader@2437c6dc

        System.out.println(ClassLoader.getSystemClassLoader());
    }

    @Test
    @DisplayName("获取类加载器")
    public void test1() {
        // 1. 第一种方式
        Class<String> clazz = String.class;
        System.out.println(clazz.getClassLoader());

        // 2. 线程
        System.out.println(Thread.currentThread().getContextClassLoader());

        // 3.
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
