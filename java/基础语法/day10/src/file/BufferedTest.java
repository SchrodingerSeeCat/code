package file;
import org.junit.Test;

import java.io.*;

/*
* 缓冲流的使用
* BufferedInputStream
* BufferedOutputStream
* BufferedReader
* BufferedWriter
* */

public class BufferedTest {
    @Test
    public void test() {
        // 获得节点流
        FileInputStream src = null;
        FileOutputStream dest = null;

        // 缓冲流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 拿到文件对象
            File srcFile = new File("fgdjk.jpg");
            File destFile = new File("test.jpg");

            src = new FileInputStream(srcFile);
            dest = new FileOutputStream(destFile);

            // 获得缓冲流
            bis = new BufferedInputStream(src);
            bos = new BufferedOutputStream(dest);

            // 读取和写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭,如果缓冲流被关闭的话，节点流也会被关闭
            try {
                if (bis == null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos == null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 如果关闭了缓冲流，被包裹的节点流也会被关闭
            //src.close();
            //dest.close();
        }
    }
}
