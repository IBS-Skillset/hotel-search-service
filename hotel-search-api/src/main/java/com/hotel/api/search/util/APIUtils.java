package com.hotel.api.search.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class APIUtils {

    private static final String DATE_FORMAT = "yyyyMMdd";

    public static LocalDate stringToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return LocalDate.parse(date,formatter);
    }


}
