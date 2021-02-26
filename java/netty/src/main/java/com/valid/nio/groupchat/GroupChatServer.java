package com.valid.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/*
* NIO群聊 服务端
* 1. 服务端启动并监听6667
* 2. 服务端接受客户端信息，并实现转发
* */
public class GroupChatServer {

    // 定义一些属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    // 完成一些初始化工作
    public GroupChatServer() {
        try{
            // 获取选择器，和channel
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();

            // 绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            // 设置非阻塞模式
            listenChannel.configureBlocking(false);
            // 注册channel
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 监听
    public void listen() {
        try{
            // 循环处理
            while(true) {
                // 不写参数会阻塞等待
                selector.select();

                // 处理获取的事件
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    // 监听到OP_ACCEPT事件
                    if(key.isAcceptable()) {
                        SocketChannel client = listenChannel.accept();

                        // 设置为非阻塞
                        client.configureBlocking(false);

                        // 将client注册到selector
                        client.register(selector, SelectionKey.OP_READ);

                        System.out.println(client.getRemoteAddress() + "上线");
                    }
                    // 监听到OP_READ事件
                    if(key.isReadable()){
                        // 从客户端获取数据
                        readData(key);
                    }

                    // 移除当前的key防止重复处理
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读取客户端的消息
    private void readData(SelectionKey key) {
        // 定义一个SocketChannel
        SocketChannel channel = null;
        try{
            // 获取关联的channel
            channel = (SocketChannel) key.channel();

            // 设置非阻塞
            channel.configureBlocking(false);

            // 创建Buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int len = channel.read(buffer);

            if(len > 0) {
                // 把缓冲区的数据转成字符串
                String msg = new String(buffer.array());
                System.out.println("客户端：" + msg);

                // 向其他客户端推送
                pushMessage(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + "离线了");
            } catch (IOException e2) {
                e2.printStackTrace();
            } finally {
                // 取消注册
                key.cancel();
                try {
                    channel.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    // 向其他客户端推送
    private void pushMessage(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息....");
        // 遍历所有注册到selector上的SocketChannel，并排除self
        for(SelectionKey key : selector.keys()) {
            Channel target = key.channel();
            if(target instanceof SocketChannel && target != self) {
                // 将msg写入buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
                ((SocketChannel) target).write(buffer);
            }
        }
    }
    public static void main(String[] args) {
        // 创建服务器对象
        GroupChatServer chatServer = new GroupChatServer();
        chatServer.listen();
    }
}
