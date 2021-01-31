package com.valid.adb.util;

import java.io.IOException;
import java.io.InputStreamReader;

public class Command {

    private static Runtime runtime;

    // 执行命令
    public static String exec(String command)  {

        Process p = null;
        InputStreamReader is = null;
        StringBuffer result = new StringBuffer();

        try {
            // 创建命令进程
            if (runtime == null) {
                runtime = Runtime.getRuntime();
            }

            // 执行命令
            p = runtime.exec(command);

            // 获取执行结果的输入流
            is = new InputStreamReader(p.getInputStream());

            // 读取输出结果
            int len;
            char[] buffer = new char[1024];
            while((len = is.read(buffer)) != -1) {
                result.append(new String(buffer, 0, len));
            }


        } catch (IOException e ) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result.toString();
    }
}
