package com.example.library.exceptions;

public class LibraryException extends RuntimeException{
    private Integer statusCode;

    public LibraryException(){

    }

    public LibraryException(Integer statusCode, String statusMessage){
        super(statusMessage);
        this.statusCode=statusCode;
    }
    public Integer getCode(){
        return statusCode;
    }
}
