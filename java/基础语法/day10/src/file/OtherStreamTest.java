package file;

import java.io.*;

/*
* 其它流
* 1. 标准的输入、输出流
* 2. 打印流
* 3. 数据流
* */

public class OtherStreamTest {
    public static void main(String[] args) {
            test2();
    }
    // 标准输入输出流
    public static void test() {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try{
            // 获取System.in的字符流
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String str;
            while(true) {
                str = br.readLine();
                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                    break;
                }
                System.out.println(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 打印流
    public static void test1(){
        FileOutputStream fos = null;
        PrintStream ps = null;
        try {
            fos = new FileOutputStream(new File("world.txt"));
            ps = new PrintStream(fos, true);
            if (ps != null) {
                // 把标准输出流重定向到改成文件
                System.setOut(ps);
            }
            for(int i = 0; i <= 255; i++){
                System.out.print((char) i);
                if (i % 50 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null)
                ps.close();
        }
    }

    // 数据流输出
    public static void test2() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("川建国");
            dos.flush();

            dos.writeInt(23);
            dos.flush();

            dos.writeBoolean(true);
            dos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null)
                    dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // 数据流的输入
    public static void test3(){
        DataInputStream dis = null;
        try{
            dis = new DataInputStream(new FileInputStream("data.txt"));

            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null)
                    dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
