package com.example.library.response;

import com.example.library.entity.Position;
import lombok.Data;

import java.util.Date;
@Data
public class ResponseEmployee {

    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String address;
    private Long contact;
    private Position position;
    private Long salary;
}
