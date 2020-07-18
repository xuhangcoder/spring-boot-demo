package com.xuhang.springbootdemo.test;

import javax.xml.crypto.Data;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author xuhang
 * @date 2019/5/20 14:25
 */
public class LocalDateTest {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println(now.minusDays(2));
        System.out.println("今天的日期是："+now);
        System.out.println("年："+now.getYear());
        System.out.println("月："+now.getMonthValue());
        System.out.println("日："+now.getDayOfMonth());
        LocalDate date = LocalDate.of(2019, 05, 21);
        System.out.println(date);
        System.out.println(date.equals(now));
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(time.plusHours(20));
        System.out.println(now.plus(2, ChronoUnit.DAYS));
        System.out.println(Clock.systemUTC());
        System.out.println(Clock.systemDefaultZone());
        System.out.println(now.isLeapYear());
        System.out.println(Period.between(now, now.plus(20, ChronoUnit.DAYS)).getDays());
        System.out.println(Instant.now());
        Date from = Date.from(Instant.now());
        System.out.println(LocalDate.parse("20190522", DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(LocalDate.parse("5 20 2019", DateTimeFormatter.ofPattern("M dd yyyy")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }
}
