package com.valid.command;

public class LightOffCommand implements Command{
    private final LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off(); // 调用接受者的方法
    }

    @Override
    public void undo() {
        light.on();
    }
}
