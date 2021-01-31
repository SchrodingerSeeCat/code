package com.valid.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest // 使用springboot的测试环境
@DisplayName("Junit5功能测试类")
public class JUnit5Test {

    @DisplayName("测试displayName注解")
    @Test
    public void testDisplayName() {
        System.out.println("测试1");
    }

    @Disabled //禁用某个测试方法
    @Test
    public void test() {
        System.out.println("测试2");
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS) // 指定方法的超时时间
    @Test
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(600);
    }

    @RepeatedTest(5)
    @Test
    public void testRepeatedTest() {
        System.out.println(5);
    }

    @BeforeEach
    public void testBeforeEach() {
        System.out.println("测试就要开始了");
    }

    @AfterEach
    public void testAfterEach() {
        System.out.println("测试结束了");
    }

    @BeforeAll
    public static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    public static void testAfterAll() {
        System.out.println("所有测试结束了");
    }
}
