package com.valid.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/*
* MappedByteBuffer，可以让文件直接在内存中修改，操作系统不需要拷贝一次
* */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("file01.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        /*
        * 参数1：使用读写模式
        * 参数2：可以直接修改的起始位置
        * 参数3：映射到内存的大小，即将1.txt的多少个字节映射到内存，可以修改的范围是0-4
        * */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        // 修改
        mappedByteBuffer.put(0, (byte) 'P');
        mappedByteBuffer.put(3, (byte) '9');

        randomAccessFile.close();
    }
}
