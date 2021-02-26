package com.valid.nio.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(7001);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 创建serverSocket
        ServerSocket serverSocket = serverSocketChannel.socket();

        // 绑定端口
        serverSocket.bind(address);

        // 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while(true) {
            SocketChannel client = serverSocketChannel.accept();

            int readCount = 0;
            while(readCount != -1) {
                try{
                    readCount = client.read(byteBuffer);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

                byteBuffer.rewind(); // 倒带 position = 0 mark作废
            }
            System.out.println("文件读取完毕");
        }
    }
}
