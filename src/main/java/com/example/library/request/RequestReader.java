package com.example.library.request;

import lombok.Data;

import java.util.Date;
@Data
public class RequestReader {
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String address;
    private Long contact;

}
