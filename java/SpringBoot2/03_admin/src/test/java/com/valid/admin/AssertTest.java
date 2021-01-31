package com.valid.admin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.Assert;

import java.time.Duration;

public class AssertTest {

    @DisplayName("测试简单断言")
    @Test
    public void testSimple() {
        int cal = cal(2, 3);
//        Assertions.assertEquals(5, cal);
        Assertions.assertEquals(4, cal, "计算失败");
    }

    public int cal(int i, int j) {
        return i + j;
    }

    @DisplayName("测试数组断言")
    @Test
    public void testArray() {
        Assertions.assertArrayEquals(new int[]{1, 2}, new int[]{2, 1}, "数组不相等");
    }

    @DisplayName("组合断言")
    @Test
    public void testAssertAll() {
        Assertions.assertAll("组合断言测试",
            () -> Assertions.assertEquals(2, 1 + 1),
            () -> Assertions.assertTrue( 1 < 0)
        );
    }

    @DisplayName("异常断言")
    @Test
    public void testAssertThrows() {
        // 扔出断言异常
        ArithmeticException exception = Assertions.assertThrows(
            // 扔出异常
            ArithmeticException.class,
            () -> System.out.println(1),
            "没有出现异常"
        );
    }

    @DisplayName("超时断言")
    @Test
    public void testAssertTimeout() {
        Assertions.assertTimeout(
            Duration.ofMillis(1000),
            () -> Thread.sleep(1001),
            "方法执行超时"
        );
    }

    @DisplayName("快速测试")
    @Test
    public void testFail() {
        Assertions.fail("通过此方法可以直接使测试失败");
    }

    @DisplayName("测试假设")
    @Test
    public void testAssumptions() {
        Assertions.assertTrue(false, "结果不是true");
        System.out.println("假设成立");
    }


    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testParameterized(int i) {
        System.out.println(i);
    }
}
