package com.valid.state;

// 状态接口
public interface State {
    void deductMoney();     // 扣除积分
    boolean raffle();       // 是否抽中奖品
    void dispensePrize();   // 发放将奖品
}
