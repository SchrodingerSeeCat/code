package com.valid.drawable.util;

import java.util.Random;

public class VerificationCode {
    public static String code() {
        // 生成验证码
        Random random = new Random();
        return random.nextInt(900000) + 100000 + "";
    }
}
