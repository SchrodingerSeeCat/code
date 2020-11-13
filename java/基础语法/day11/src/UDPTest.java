import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest {
    @Test
    public void send(){
        DatagramSocket socket = null;
        try {
            // 创建socket
            socket = new DatagramSocket();

            // 创建数据包
            String str = "我是UDP方式发送的数据包";
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(str.getBytes(), 0, str.length(), inet, 8080);

            // 发送数据包
            socket.send(packet);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null)
                socket.close();
        }
    }

    @Test
    public void receiver() {
        // 创建套接字
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8080);

            // 创建接受的数据包
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

            // 接受数据
            socket.receive(packet);

            // 输出数据
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null)
                socket.close();
        }
    }
}
