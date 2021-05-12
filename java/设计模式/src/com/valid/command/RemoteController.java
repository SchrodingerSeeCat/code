package com.valid.command;

public class RemoteController {
    // 开按钮
    private final Command[] onCommands;
    private final Command[] offCommands;

    // 撤销命令
    private Command undo;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            setCommand(i, new NoCommand(), new NoCommand());
        }
    }

    // 给指定按钮设置命令
    public void setCommand(int num, Command on, Command off) {
        onCommands[num] = on;
        offCommands[num] = off;
    }

    // 按下开按钮
    public void onButtonWasPushed(int num) {
        // 找到你按下的开的按钮，并调用对应方法
        onCommands[num].execute();
        // 记录这次的操作，用于撤销
        undo = onCommands[num];
    }

    // 按下关按钮
    public void offButtonWasPushed(int num) {
        // 找到你按下的关的按钮，并调用对应方法
        offCommands[num].execute();
        // 记录这次的操作，用于撤销
        undo = offCommands[num];
    }

    // 按下撤销按钮
    public void undoButtonWasPushed() {
        undo.undo();
    }
}
