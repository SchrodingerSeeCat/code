package file;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class FileTest {
    @Test
    public void test(){
        File file1 = new File("1.txt"); // 相对于当前module

        File file2 = new File("/home/valid/code/java/基础语法", "day10");

        File file3 = new File(file2, "1.txt");
        System.out.println(file3);
    }
    @Test
    public void test1(){
        File file = new File("hello.txt");
        File dir = new File("/home/valid/code/java/基础语法/day10/test");

        // 获取绝对路径
        System.out.println(file.getAbsolutePath());

        // 获取路径
        System.out.println(file.getPath());

        // 获取文件或目录名
        System.out.println(file.getName() + " " + dir.getName());

        // 获取文件或目录的上一级目录
        System.out.println(file.getParent() + " " + dir.getParent());

        // 获取文件的大小
        System.out.println(file.length());

        // 最后一次修改时间
        System.out.println(file.lastModified());
        System.out.println(new Date(file.lastModified()));

        // 获取目录下的文件或目录名
        String[] list = dir.list();
        for(String f : list) {
            System.out.println(f);
        }

        // 获取目录下的文件或目录的File对象
        File[] listRoute = dir.listFiles();
        for(File f : listRoute) {
            System.out.println(f);
        }

        // 移动和重命名
//        File dest = new File("hello.txt");
//        System.out.println(file.renameTo(dest));

        // 判断是否是文件目录
        System.out.println(file.isDirectory());
        System.out.println(dir.isDirectory());

        // 判断是否是文件
        System.out.println(file.isFile());
        System.out.println(dir.isFile());

        // 判断是否存在
        System.out.println(file.exists());

        // 判断是否可读
        System.out.println(file.canWrite());

        // 判断是否可写
        System.out.println(file.canWrite());

        // 判断是否可执行
        System.out.println(file.canExecute());

        // 判断是否隐藏
        System.out.println(file.isHidden());
    }

    @Test
    public void test2() {
        File file = new File("word.txt");

        if(!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test3(){
        File dir = new File("/home/valid/code/java/基础语法/day10/tes/practice");
        if(dir.mkdirs()) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");
        }
    }
}
