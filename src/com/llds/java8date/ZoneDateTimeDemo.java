package com.llds.java8date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Author lc_666
 * @Date 2020/7/25
 */
public class ZoneDateTimeDemo {

    @Test
    public void test() {
        // 创建ZonedDateTime
        ZonedDateTime time1 = ZonedDateTime.now();
        System.out.println(time1);//2020-07-25T13:17:38.518+08:00[Asia/Shanghai]
        ZonedDateTime time2 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(time2);//2020-07-25T14:17:38.520+09:00[Asia/Tokyo]
        // 转换为当地时间
        LocalDateTime localDateTime = time2.toLocalDateTime();
        System.out.println(localDateTime);//2020-07-25T14:25:19.349
    }

    @Test
    public void test2() {
        //时间转换
        ZonedDateTime z1 = ZonedDateTime.of(2020, 8, 1, 12, 0, 0, 0, ZoneId.of("Asia/Shanghai"));
        ZonedDateTime z2 = z1.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
        System.out.println(z1);//2020-08-01T12:00+08:00[Asia/Shanghai]
        System.out.println(z2);//2020-08-01T13:00+09:00[Asia/Tokyo]
    }
}
