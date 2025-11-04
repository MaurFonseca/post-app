package com.mauricio.mongo.ex.post_app.service.exception;

public record ErrorResponse (String timestamp, int status, String message, String path){
}
