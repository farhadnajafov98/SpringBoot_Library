package com.example.library.request;

import com.example.library.entity.Position;
import lombok.Data;

import java.util.Date;
@Data
public class RequestEmployee {
    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String address;
    private Long contact;
    private Position position;
    private Long salary;
}
