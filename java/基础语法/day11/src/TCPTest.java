/*
* 实现TCP的网络编程
* */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {
    @Test
    public void client(){
        // 客户端
        InetAddress inetAddress = null;
        Socket socket = null;
        OutputStream os = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            // 设置服务器地址
            inetAddress = InetAddress.getByName("127.0.0.1");

            // 获取套接字
            socket = new Socket(inetAddress, 8080);

            // 发送数据
            os = socket.getOutputStream();
            os.write("Hello, I am a client".getBytes());

            // 关闭数据的输出
            socket.shutdownOutput();

            // 接受服务端的反馈
            inputStream = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] message = new byte[1024];
            int len;
            while((len = inputStream.read(message)) != -1) {
                baos.write(message, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server(){
        // 服务端
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        OutputStream outputStream = null;
        try {
            // 创建服务器
            serverSocket = new ServerSocket(8080);

            // 接受客户端套接字
            socket = serverSocket.accept();

            // 获取输入流
            inputStream = socket.getInputStream();

            // 读取数据
            baos = new ByteArrayOutputStream();
            byte[] message = new byte[1024];
            int len;
            while((len = inputStream.read(message)) != -1) {
                baos.write(message, 0, len);
            }
            System.out.println(baos.toString());

            // 给予客户端反馈
            outputStream = socket.getOutputStream();
            outputStream.write("I am a server".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (baos != null)
                    baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
