package com.ldd.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ldd
 * @Date 2023/12/8
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handlerException(HttpServletRequest request,Throwable ex){
        return new ResponseEntity<>("global exception", HttpStatus.OK);
    }
}
