package com.valid.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

// FileChannel写操作
public class NIOFileChannelWrite {
    public static void main(String[] args) throws IOException {
        String str = "Hello 中国";

        // 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("file01.txt");

        // 通过输出流获取Channel
        FileChannel channel = fileOutputStream.getChannel();

        // 创建一个缓冲区，并将待写入的数据放入缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes(StandardCharsets.UTF_8));

        // 对buffer进行反转
        buffer.flip();

        // 将数据写入Channel
        channel.write(buffer);

        // 关闭流
        fileOutputStream.close();
    }
}
