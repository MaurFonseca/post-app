package com.mauricio.mongo.ex.post_app.service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@ControllerAdvice
public class GlobalExcepetionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> objectNotFoundHandler(ObjectNotFoundException e, HttpServletRequest request){
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
