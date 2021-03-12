package com.xschen.java8.ch12;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeExamples {
    private static final ThreadLocal<SimpleDateFormat> threadSafeDateFormat =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
//        useOldDate();
//        useLocalDate();

        useDateFormatter();
    }

    private static void useOldDate() {
        Date date = new Date(2021-1900, 3, 10);
        System.out.println(date);

        System.out.println(threadSafeDateFormat.get().format(date));

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 3, 10);
        System.out.println(calendar.getTime());
    }

    private static void useLocalDate() {
        LocalDate date = LocalDate.of(2021, 3, 10);
        int year = date.getYear(); // 2021
        Month month = date.getMonth(); // MARCH
        int day = date.getDayOfMonth(); // 10
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean isLeap = date.isLeapYear();
        System.out.println(date);

        int y = date.get(ChronoField.YEAR);
        int m = date.get(ChronoField.MONTH_OF_YEAR);
        int d = date.get(ChronoField.DAY_OF_MONTH);

        LocalTime time = LocalTime.of(17, 56, 01); // 17:56:00
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDateTime dt1 = LocalDateTime.of(2021, 3, 10, 17, 56, 01);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(17, 56, 01);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        System.out.println(dt5);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(date1);
        System.out.println(time1);

        /**
         * unix 元年 1970-01-01 开始所经历的秒数, 便于机器处理
         */
        Instant instant = Instant.ofEpochSecond((2021 - 1970) * 365 * 86400);
        Instant now = Instant.now();
        System.out.println(instant);
        System.out.println(now);

        Duration d1 = Duration.between(LocalTime.of(17, 01, 01), time);
        Duration d2 = Duration.between(instant, now);
        System.out.println(d1.getSeconds());
        System.out.println(d2.getSeconds());

        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println(threeMinutes.getSeconds());
    }

    private static void useDateFormatter() {
        LocalDate date = LocalDate.of(2021, 3, 10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(date.format(formatter));
        System.out.println(date.format(italianFormatter));

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.YEAR)
                .appendLiteral("-")
                .appendValue(ChronoField.MONTH_OF_YEAR, 2)
                .appendLiteral("-")
                .appendValue(ChronoField.DAY_OF_MONTH, 2)
                .toFormatter();

        System.out.println(date.format(complexFormatter));
    }
}
