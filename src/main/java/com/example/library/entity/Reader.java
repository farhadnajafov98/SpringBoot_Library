package com.example.library.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "READER")
@DynamicInsert
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME", length =50)
    private String name;
    @Column(name="SURNAME", length = 50)
    private String surName;
    @Column(name="DATE_OF_BIRTH")
    @DateTimeFormat(style = "dd/mm/yyyy")
    private Date dateOfBirth;
    @Column(name="ADDRESS", length = 100)
    private String address;
    @Column(name="CONTACT", length = 10)
    private Long contact;
    @Column(name="DATA_DATE")
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_date;
    @Column(name="ACTIVE")
    @ColumnDefault(value = "1")
    private Integer active;
}
