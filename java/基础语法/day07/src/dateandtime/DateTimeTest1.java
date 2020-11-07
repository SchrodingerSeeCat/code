package dateandtime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/*
* JDK8的时间日期类
* */
public class DateTimeTest1 {
    @Test
    public void test1(){
        // LocalDate LocalTime LocalDateTime
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of() 设置指定的年，月，日，时，分，秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 11, 7, 16, 30);
        System.out.println(localDateTime1);

        // getXxx 获取年，月，日，时，分，秒
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getMonth());
        System.out.println(localDateTime1.getMonthValue());

        // 设置日期
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(22);
        System.out.println(localDateTime2);

        // 添加日期时间
        LocalDateTime localDateTime3 = LocalDateTime.now();
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 =  localDateTime3.plusDays(3);
        System.out.println(localDateTime4);

    }

    @Test
    public void test2(){
        // Instant
        Instant instant = Instant.now();
        System.out.println(instant); // 2020-11-07T08:50:44.950285Z、
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        // 获取对应的时间戳
        long l = instant.toEpochMilli();
        System.out.println(l);

        // 解析
        Instant instant1 = Instant.ofEpochMilli(1604739444190L);
        System.out.println(instant1);
    }

    @Test
    public void test3(){
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);

        // 解析
        TemporalAccessor parse = formatter.parse("2020-11-07T19:33:55.475751");
        System.out.println(parse);
    }

    @Test
    public void test4(){
        // 本地化相关的格式
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str = formatter.format(localDateTime);
        System.out.println(str);
    }

    @Test
    public void test5(){
        // 自定义相关的格式
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str = formatter.format(localDateTime);
        System.out.println(str);

        // 解析
        TemporalAccessor date =  formatter.parse("2020-11-07 08:03:00");
        System.out.println(date);
    }
}
