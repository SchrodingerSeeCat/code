package com.valid.state;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("状态模式")
    public void test() {
        Activity activity = new Activity(1);
        for (int i = 0; i < 5; i++) {
            System.out.println("===="+ (i + 1) + "====");
            // 参加抽奖，第一步点击扣除积分
            activity.deductMoney();

            // 第二步抽奖
            activity.raffle();
        }
    }
}
