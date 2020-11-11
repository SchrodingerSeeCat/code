package io;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {
    @Test
    // 读入文件
    public void test(){

        // 2. 提供具体的流
        FileReader fr = null;
        try {
            // 1. 实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");

            fr = new FileReader(file);

            // 3. 读入数据
            // rade() 返回读入的一个字符, 到文件末尾返回-1
//            int data = fr.read();
//            while(data != -1) {
//                System.out.print((char) data);
//                data = fr.read();
//            }

            // read(char[] cbuf) 返回每次读入到cbuf的字符数
            char[] cbuf = new char[5];
            int num = 0;
            while((num = fr.read(cbuf)) != -1) {
//                for(int i = 0; i < num; i++){
//                    System.out.print(cbuf[i]);
//                }
                System.out.print(new String(cbuf, 0, num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    // 写出文件
    public void test1() {
        // 2. 提供相应的流
        FileWriter fw = null;
        try {
            // 1.提供File类的对象，指明写出到的文件
            File file = new File("hello.txt");
            fw = new FileWriter(file, true);

            // 3. 写出的操作

            fw.write("Hello Java");
            fw.write(" I want to learn Java");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流资源的关闭
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
