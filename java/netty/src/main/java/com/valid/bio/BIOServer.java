package com.valid.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 1.创建一个线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 2.如果有客户端连接，就创建一个线程，与之通信
        ServerSocket serverSocket = new ServerSocket(6666);
        while(true) {
            // 监听客户端
            final Socket client = serverSocket.accept();

            // 创建线程与之通信
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(client);
                }
            });
        }
    }

    // 处理请求
    public static void handler(Socket client) {
        byte[] bytes = new byte[1024];
        InputStream inputStream = null;

        // 获取输入流
        try {
            inputStream = client.getInputStream();
            int read = -1;
            System.out.println("线程信息 id = " + Thread.currentThread().getId() + " 名字 = " + Thread.currentThread().getName());
            // 循环读取客户端发送的数据
            while(true) {
                read = inputStream.read(bytes);
                if(read != -1) {
                    System.out.println(new String(bytes, 0, read));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
