package com.valid.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {
    // 定义相关的属性
    private final String HOST = "127.0.0.1"; // 服务器的ip
    private final int PORT = 6667; // 服务器的端口
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    // 完成初始化工作
    public GroupChatClient() {
        try {
            selector = Selector.open();

            // 连接服务器
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            // 设置非阻塞
            socketChannel.configureBlocking(false);

            // 将channel注册到selector
            socketChannel.register(selector, SelectionKey.OP_READ);
            // 得到username
            username = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(username + "客户端准备好了...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 向服务器发送消息
    public void sendInfo(String info) {
        info = username + ": " + info;
        try{
            socketChannel.write(ByteBuffer.wrap(info.getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取从服务器回复的消息
    public void readInfo() {
        try {
            // 接受事件
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if(key.isReadable()) {
                    // 得到相应的通道
                    SocketChannel channel = (SocketChannel)key.channel();

                    // 得到一个Buffer
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);

                    // 把读到的缓冲区数据转换为字符串
                    String msg = new String(buffer.array());
                    System.out.println(msg.trim());
                }

                // 移除key，防止重复操作
                iterator.remove();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 启动客户端
        GroupChatClient chatClient = new GroupChatClient();

        //启动一个线程，每隔3秒，读取从服务器发送的数据
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    chatClient.readInfo();
                    try{
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        // 发送数据给服务端
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String s = scanner.nextLine();
            chatClient.sendInfo(s);
        }
    }
}
