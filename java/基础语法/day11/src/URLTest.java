import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    @Test
    public void test(){
        try {
            URL url = new URL("https://www.baidu.com/");
            // 获取该URL的协议名
            System.out.println(url.getProtocol());

            // 获取该URL的端口号
            System.out.println(url.getPort());

            // 获取该URL的文件路径
            System.out.println(url.getPath());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
