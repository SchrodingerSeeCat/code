package com.valid.command;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Client {
    @Test
    @DisplayName("命令模式")
    public void test() {
        // 创建电灯接受者
        LightReceiver receiver = new LightReceiver();

        // 创建电灯相关的开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(receiver);
        LightOffCommand lightOffCommand = new LightOffCommand(receiver);

        // 创建控制器
        RemoteController remoteController = new RemoteController();

        // 设置相关命令
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("===按下开===");
        remoteController.onButtonWasPushed(0);
        System.out.println("===按下关===");
        remoteController.offButtonWasPushed(0);
        System.out.println("===撤销===");
        remoteController.undoButtonWasPushed();
    }
}
