package file;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
//        test();
    }
    @Test
    public void test(){

        RandomAccessFile rafr = null;
        RandomAccessFile rafrw = null;
        try {
            rafr = new RandomAccessFile("hello.txt", "r");
            rafrw = new RandomAccessFile("hello1.txt", "rw");

            byte[] buffer = new byte[1024];
            int len;
            while(true){
                if (((len = rafr.read(buffer)) != -1)) {
                    rafrw.write(buffer, 0, len);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rafr != null)
                    rafr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (rafrw != null)
                    rafrw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() throws IOException {
        RandomAccessFile rafrw = new RandomAccessFile("hello1.txt", "rw");
        rafrw.seek(3);
        rafrw.write("abc".getBytes());
        rafrw.close();
    }

}
