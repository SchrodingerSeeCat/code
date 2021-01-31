package com.valid.adb;

import com.valid.adb.util.Command;
import com.valid.adb.util.Phone;

public class ADB {
    private Phone phone;

    public void ADB() {
        phone = Phone.getPhone();
    }

    // 启动调启Activity
    public void start(String activity) {
        System.out.println(Command.exec("adb shell am start -n " + activity));
    }

    // 查看正在运行的应用名和包名
    public void list(){
        System.out.println(Command.exec("adb shell dumpsys window w |findstr \\/ |findstr name="));
    }
}
