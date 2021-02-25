package com.valid.nio;

import java.nio.ByteBuffer;

public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(64);
        for(int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        buffer.flip();
        // 得到一个只读的buffer
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
    }
}
