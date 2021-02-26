package com.valid.nio.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        // 连接服务器
        socketChannel.connect(new InetSocketAddress("localhost", 7001));

        String filename = "file01.txt";

        // 得到一个文件channel
        FileChannel fileChannel = new FileInputStream(filename).getChannel();

        // Linux中一个transferTo方法就可以完成传输
        // 在windows中 一次transferTo只能发送8M的数据，就需要分段传输，而且要注意传输时的位置

        long len = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送的总的字节数 = " + len);

        // 关闭
        fileChannel.close();
    }
}
