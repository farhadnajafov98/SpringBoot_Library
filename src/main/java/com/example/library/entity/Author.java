package com.example.library.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="AUTHOR")
@DynamicInsert
public class Author {
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
    @Column(name="COUNTRY", length = 50)
    @ManyToMany
    private Set<Book> book;
    @Column(name="COUNTRY", length = 20)
    private String country;
    @Timestamp
    @CreationTimestamp()
    @Column(name="DATA_DATE")
    private Date data_date;
    @Column(name="ACTIVE", columnDefinition = "1")
    private Integer active;




}
