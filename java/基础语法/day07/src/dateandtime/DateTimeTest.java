package dateandtime;

/*
* JDK8之前的日期和时间
* */

import org.junit.Test;

import javax.xml.datatype.DatatypeFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {
    @Test
    public void test1(){
        // System 时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void test2(){
        // java.lang.util
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());

        Date date1 = new Date(1604723179115L);
        System.out.println(date1);
    }

    @Test
    public void test3(){
        // java.sql.util
        java.sql.Date date = new java.sql.Date(1604723409503L);
        System.out.println(date);
    }

    @Test
    public void test4(){
        java.util.Date date = new java.util.Date();
        java.sql.Date date2 = new java.sql.Date(date.getTime());
    }

    // java.text.SimpleDateFormat
    @Test
    public void test5(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 格式化
        Date date = new Date();
        String format = sdf.format(date);
        System.out.println(format);

        // 解析
        String str = "11/7/20, 3:21 PM";
        try {
            Date date1 = sdf.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test6(){
        // 按照自定义的格式格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String format = sdf.format(new Date());
        System.out.println(format);
        // 解析
        try {
            Date date = sdf.parse("2020-11-07 03:29:49");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test7(){
        // Calendar 日历类(抽象类)的使用
        // 实例化
        // 调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("这个月的第 " + day + " 天");

        calendar.set(Calendar.DAY_OF_MONTH, 22);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天更改为 " + day + " 天");

        calendar.add(Calendar.DAY_OF_MONTH, 3);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("今天加 " + day + " 天");

        Date date = calendar.getTime();
        System.out.println(date);

        Date date1 = new Date();
        calendar.setTime(date1);
    }
}
