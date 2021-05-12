package com.valid.memento;

public class Originator {
    private String state; // 状态信息

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // 保存状态
    public Memento saveState() {
        return new Memento(state);
    }

    // 恢复状态
    public void refreshState(Memento memento) {
        state = memento.getState();
    }
}
