package cn.com.cworks.java8date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeDemo {

    @Test
    public void test() {
        // 获取当前日期 时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);//2020-07-25T09:57:14.404
        LocalDate date = LocalDate.now();
        System.out.println(date);//2020-07-25
        LocalTime time = LocalTime.now();
        System.out.println(time);//09:57:14.404

        // 获取指定的日期 时间
        LocalDateTime dateTime1 = LocalDateTime.of(2009, 8, 7, 12, 59, 0);
        System.out.println(dateTime1);//2009-08-07T12:59
    }

    @Test
    public void tes1() {
        // 格式化输出
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.of(2009, 12, 23, 14, 35, 6)));
        // 解析时间
        LocalDateTime parse = LocalDateTime.parse("2009/12/23 14:35:06", dtf);
        System.out.println(parse);
    }

    @Test
    public void test2() {
        // 日期加减 且可以进行链式调用
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2020-07-25T11:06:13.798
        LocalDateTime dateTime = now.plusDays(1).minusHours(1);
        System.out.println(dateTime);//2020-07-26T10:06:13.798
    }

    @Test
    public void test3() {
        // 调整日期 withYear() withMonth() withDayOfMonth() withHour() withMinute() withSecond()
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2020-07-25T11:08:03.271
        LocalDateTime dateTime = now.withDayOfMonth(19).withHour(12).withMinute(59);
        System.out.println(dateTime);//2020-07-19T12:59:03.271
    }

    @Test
    public void test4() {
        // 使用with设置时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);//2020-07-25T11:26:01.365
        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with); //2020-07-01T11:25:07.998
        //其他计算
        LocalDateTime with1 = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(with1);//2020-07-06T12:46:19.345 本月的第一个周一
    }

    @Test
    public void test5() {
        //Duration和Period
        //Duration表示两个时刻之间的时间间隔
        //Period表示两个日期之间的天数
        LocalDateTime start = LocalDateTime.of(2000, 1, 1, 12, 0, 0);
        LocalDateTime end = start.minusDays(3);
        Duration d = Duration.between(start, end);
        System.out.println(d.getSeconds());//-259200
        Period p = Period.between(start.toLocalDate(), end.toLocalDate());
        System.out.println(p.getDays());//-3
    }

    @Test
    public void test6() {

    }


}
