package com.valid.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("file01.txt");
        FileChannel readChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("file02.txt");
        FileChannel writeChannel = fileOutputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);
        while(true) {
            // 从channel中读取数据到buffer
            buffer.clear(); // 清空buffer
            int len = readChannel.read(buffer);
            if(len == -1) {
                break;
            }

            // 从buffer中写出数据到channel
            buffer.flip();
            writeChannel.write(buffer);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
