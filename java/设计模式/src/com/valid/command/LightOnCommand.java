package com.valid.command;

public class LightOnCommand implements Command{
    private final LightReceiver light;

    public LightOnCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on(); // 调用接受者的方法
    }

    @Override
    public void undo() {
        light.off();
    }
}
