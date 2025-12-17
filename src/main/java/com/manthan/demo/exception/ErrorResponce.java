package com.manthan.demo.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponce {
    private long status;
    private String message;
}
