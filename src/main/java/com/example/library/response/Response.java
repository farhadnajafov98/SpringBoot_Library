package com.example.library.response;

import lombok.Data;

@Data
public class Response <T>{
    private T t;
    private ResponseStatus status;
}
