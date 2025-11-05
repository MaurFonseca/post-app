package com.mauricio.mongo.ex.post_app.service.utility;


import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

    public static String decode(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static LocalDate decodeData(String textDate, LocalDate defaultDate){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate date = LocalDate.parse(textDate, fmt);
            return date;
        }catch (DateTimeParseException e){
            return defaultDate;
        }
    }
}
