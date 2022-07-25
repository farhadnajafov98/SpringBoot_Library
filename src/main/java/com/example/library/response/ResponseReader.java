package com.example.library.response;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseReader {
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String address;
    private Long contact;

}
