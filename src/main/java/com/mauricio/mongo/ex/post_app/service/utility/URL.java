package com.mauricio.mongo.ex.post_app.service.utility;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URL {

    public static String decode(String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
