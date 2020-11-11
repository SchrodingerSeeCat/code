package map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void test(){
        FileInputStream fis = null;
        try{
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis); // 加载流对应的文件

            // 获取对应的属性
            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name: " + name + "\npassword: " + password);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            // 关闭流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
