package com.manthan.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public String HandleUserNotFoundException(UserNotFoundException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(InvalidRecquestException.class)
    public String HandleInvalidRecquestException(InvalidRecquestException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String GenrealException(Exception exception){
        return "Unexcepted exception" + exception.getMessage();
    }

}
