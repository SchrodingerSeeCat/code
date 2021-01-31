package com.valid.adb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 手机实体类
* */
public class Phone {

    private int width; // 手机的宽度 px
    private int height; // 手机的高度 px
    private int size;  // 手机的大小 英寸
    private int dpi;  // 手机的屏幕密度

    private static Phone phone;

    private Phone() {
        getScreenSize();
    }

    // 获取手机实例
    public static Phone getPhone() {
        if(phone != null) {
            phone = new Phone();
        }
        return phone;
    }

    // dp转px
    public int convert(int dp) {
        return dp * (dpi / 160);
    }


    /*
     * dpi的计算公式 Math.sqrt(width * width + height * height) / 屏幕的大小(英寸)
     * dp与px的转换 px = dp * (dpi / 160)
     * */

    // 获取屏幕分辨率
    private void getScreenSize() {
        String result = Command.exec("adb shell wm size");

        Matcher matcher = regular(result);

        // 获取宽度
        matcher.find();
        width = Integer.parseInt(matcher.group());

        // 获取高度
        matcher.find();
        height = Integer.parseInt(matcher.group());

        // 获取dpi
        result = Command.exec("adb shell wm density");
        matcher = regular(result);
        matcher.find();
        dpi = Integer.parseInt(matcher.group());
    }

    // 查找数字
    private Matcher regular(String result) {
        Pattern p = Pattern.compile("(\\d{3,4})");
        return p.matcher(result);
    }
}
