package com.valid.nio;

import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        // 创建一个Buffer,大小为5
        IntBuffer intBuffer = IntBuffer.allocate(5);

        // 向Buffer中存放数据
        for(int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }

        // 获取buffer中的数据，flip读写转换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
