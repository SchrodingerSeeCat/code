package practice;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePractice {
    @Test
    public void test(){
        // 将字符串2020-09-08转换为java.sql.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2020-09-08");
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            System.out.println(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        // 三天打渔两天晒网 1990-01-01 xxxx-xx-xx打渔or晒网？
        // 2020-09-08
    }
}
