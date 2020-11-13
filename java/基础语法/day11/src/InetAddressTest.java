import java.net.InetAddress;
import java.net.UnknownHostException;
/*
*
* IP
* */
public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress inetAddress1 = null;
        InetAddress inetAddress2 = null;
        try {
            inetAddress1 = InetAddress.getByName("192.168.1.1");
            inetAddress2 = InetAddress.getByName("www.baidu.com");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(inetAddress1);
        System.out.println(inetAddress2);
    }
}
