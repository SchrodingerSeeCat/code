package com.valid.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws Exception{
        // 创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 得到一个Selector对象
        Selector selector = Selector.open();

        // 绑定端口，在服务器监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        // 设置为非阻塞式
        serverSocketChannel.configureBlocking(false);

        // 把serverSocketChannel注册到selector关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环等待客户端连接
        while(true) {

            // 等待1秒连接
            if(selector.select(1000) == 0) {
                // 没有事件发生
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }

            // 如果返回的>0，表明已经获取到关注的事件，获取相关的selectionKey集合
            // selector.selectedKeys() 返回关注事件的集合，通过selectionKeys 反向获取Channel
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            // 遍历
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()) {
                // 获取SelectionKey
                SelectionKey key = iterator.next();
                // 根据key 对应的通道发生的事件做相应处理
                if(key.isAcceptable()) {
                    // 如果是OP_ACCEPT，表明有新的连接
                    // 给该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false); // 设置为非阻塞

                    System.out.println("客户端连接成功");
                    // 将socketChannel注册到selector, 关注事件为OP_READ, 同时给socketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if(key.isReadable()) {
                    // 发生OP_READ
                    // 通过key反向获取socketChannel
                    SocketChannel channel = (SocketChannel)key.channel();

                    // 获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();

                    channel.read(buffer);
                    System.out.println("客户端：" + new String(buffer.array()));
                }

                // 手动从集合中移除当前的selectionKey，防止重复操作
                iterator.remove();
            }
        }
    }
}
