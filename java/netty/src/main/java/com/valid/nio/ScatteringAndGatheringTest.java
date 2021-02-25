package com.valid.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/*
* Scattering: 将数据写入到buffer时，可以采用buffer数据，依次写入分散
* Gathering: 从buffer读取数据时，可以采用buffer数组，依次读
* */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws Exception{

        // 使用ServerSocketChannel和SocketChannel网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        // 绑定端口到Socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        // 创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等待客户端连接(telnet)
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8; //假定客户端接受8个字节
        // 循环读取
        while(true) {
            int byteRead = 0;

            while(byteRead < messageLength) {
                long len = socketChannel.read(byteBuffers);
                byteRead += len; // 累计读取的字节数
                System.out.println("byteRead = " + byteRead);

                Arrays.asList(byteBuffers).stream().map(buffer -> "position="+ buffer.position() + ", limit=" + buffer.limit()).forEach(System.out::println);
            }

            // 将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            // 将数据读出显示到客户端
            long byteWrite = 0;
            while(byteWrite < messageLength) {
                long len = socketChannel.write(byteBuffers);
                byteWrite += len;
            }

            // 将所有的buffer进行clear
            Arrays.asList(byteBuffers).forEach(ByteBuffer::clear);
            System.out.println("byteRead=" + byteRead + ", byteWrite=" + byteWrite + ", messageLength=" + messageLength);
        }
    }
}
