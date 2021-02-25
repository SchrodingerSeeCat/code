package com.valid.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NIOFileChannel2 {
    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("file01.txt");
        FileChannel readChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("file02.txt");
        FileChannel writeChannel = fileOutputStream.getChannel();

        writeChannel.transferFrom(readChannel, 0, readChannel.size());

        fileInputStream.close();
        fileOutputStream.close();
    }
}
