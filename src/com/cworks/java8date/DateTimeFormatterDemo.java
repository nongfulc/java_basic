package com.cworks.java8date;

import org.junit.Test;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @Author lc_666
 * @Date 2020/7/25
 */
public class DateTimeFormatterDemo {

    @Test
    public void test1(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        //DateTimeFormatter 线程安全
        //初始化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss", Locale.US);
        System.out.println(dtf.format(zonedDateTime));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss EE", Locale.CHINA);
        System.out.println(dateTimeFormatter.format(zonedDateTime));
    }

    @Test
    public void test2(){
        // Instant.now()获取当前时间戳
        System.out.println(System.currentTimeMillis());//1595656182002
        System.out.println(Instant.now().getEpochSecond());//1595656182
    }
}
