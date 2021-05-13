package com.valid.state;

public class NoRaffleState implements State{
    private final Activity activity;

    public NoRaffleState(Activity activity) {
        this.activity = activity;
    }

    // 可以扣积分,并设置为可以抽奖的状态
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分，可以抽奖");
        activity.setState(activity.getCanRaffleState());
    }

    // 当前状态不能抽奖
    @Override
    public boolean raffle() {
        System.out.println("支付积分之后才能抽奖");
        return false;
    }

    // 当前状态不能发放奖品
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
