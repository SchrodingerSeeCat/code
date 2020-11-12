package file;

import org.junit.Test;

import java.io.*;

/*
* 转换流
* */
public class InputStreamReaderTest {
    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream("hello.txt");
            fos = new FileOutputStream("word.txt");

            // 使用系统默认的字符集
            // InputStreamReader isr = new InputStreamReader(fis);
            isr = new InputStreamReader(fis, "UTF-8");
            osw = new OutputStreamWriter(fos, "GBK");

            char[] cbuf = new char[10];
            int len;
            while((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (osw != null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
