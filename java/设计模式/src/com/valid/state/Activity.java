package com.valid.state;

public class Activity {
    private State state;            // 当前状态
    private int count = 0;          // 奖品数量

    // 四种状态
    private State noRaffleState = new NoRaffleState(this);
    private State canRaffleState = new CanRaffleState(this);
    private State dispenseState = new DispenseState(this);
    private State dispenseOutState = new DispenseOutState(this);

    public Activity(int count) {
        this.state = getNoRaffleState();
        this.count = count;
    }

    // 扣除积分
    public void deductMoney() {
        state.deductMoney();
    }

    // 抽奖
    public void raffle() {
        // 抽奖成功，领奖
        if (state.raffle()) {
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // 这里请大家注意，每领取一次奖品，count--
    public int getCount() {
        return count--;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setNoRaffleState(NoRaffleState noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public void setCanRaffleState(CanRaffleState canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public void setDispenseOutState(DispenseOutState dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }
}
