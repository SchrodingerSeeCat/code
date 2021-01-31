package com.valid.adb.util;

import com.valid.adb.ADB;
import org.junit.Test;

public class CommandTest {
    @Test
    public void test1() {
        // 测试命令
        String result = Command.exec("ping www.baidu.com");
        System.out.println(result);
        System.out.println("我收获哦哦哦");
    }

    @Test
    public void test2() {
        // 测试获取屏幕分辨率
        ADB adb = new ADB();
        adb.list();
    }


}
