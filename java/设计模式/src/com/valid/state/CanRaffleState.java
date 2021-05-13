package com.valid.state;

import java.util.Random;

public class CanRaffleState implements State{
    private Activity activity;

    public CanRaffleState(Activity activity) {
        this.activity = activity;
    }

    // 扣除积分不能再扣
    @Override
    public void deductMoney() {
        System.out.println("已经扣取过积分了");
    }

    // 抽奖改变状态
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍等");
        int num = new Random().nextInt(10);
        if (num == 0) {
            // 中奖发放奖品
            activity.setState(activity.getDispenseState());
            return true;
        }

        System.out.println("很遗憾没有抽中奖品");
        activity.setState(activity.getNoRaffleState());
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("没有中奖，不能发放奖品");
    }
}
