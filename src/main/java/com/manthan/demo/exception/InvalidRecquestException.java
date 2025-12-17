package com.manthan.demo.exception;

public class InvalidRecquestException extends RuntimeException {
    public InvalidRecquestException(String message) {
        super(message);
    }
}
