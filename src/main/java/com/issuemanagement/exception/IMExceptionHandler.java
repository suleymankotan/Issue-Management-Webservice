package com.issuemanagement.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
@Slf4j
public class IMExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> responseEntity(Exception exception, WebRequest request){
        log.error("Exception: "+ exception);
        return new ResponseEntity<>(new ExceptionModel(new Date(),exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
