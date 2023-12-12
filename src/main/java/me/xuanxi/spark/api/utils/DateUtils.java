package me.xuanxi.spark.api.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

    public static LocalDateTime parseDateTime(String src){
        return LocalDateTime.parse(src, formatter);
    }

    public static String parse(LocalDateTime dateTime){
        return dateTime.format(formatter);
    }
}
