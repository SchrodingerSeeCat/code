package file;

import org.junit.Test;

import java.io.*;

public class FileInputOutputStreamTest {
    @Test
    public void test() {
        FileInputStream fisSrc = null;
        FileOutputStream fisDest = null;
        try {
            File src = new File("fgdjk.jpg");
            File dest = new File("test.jpg");

            fisSrc = new FileInputStream(src);
            fisDest = new FileOutputStream(dest, true);

            byte[] cbuf = new byte[10];
            int num;
            while((num = fisSrc.read(cbuf)) != -1) {
                fisDest.write(cbuf, 0, num);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fisSrc != null)
                    fisSrc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fisDest != null)
                    fisDest.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
