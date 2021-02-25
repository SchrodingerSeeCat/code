package com.valid.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannelRead {
    public static void main(String[] args) throws IOException {
        // 创建一个输出流
        FileInputStream fileInputStream = new FileInputStream("file01.txt");

        // 通过输出流获取Channel
        FileChannel channel = fileInputStream.getChannel();

        // 创建一个缓冲区，并文件中的数据放入缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);

        System.out.println(new String(buffer.array()));
        // 关闭流
        fileInputStream.close();
    }
}
