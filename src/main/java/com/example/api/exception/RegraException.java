package com.example.api.exception;

public class RegraException extends RuntimeException{

    private static final long serialVersion = 1L;

    public RegraException(String message){
        super(message);
    }
}
