package com.example.library.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="POSITION")
@DynamicInsert
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name="NAME", length = 50)
    private String name;
    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employee;
    @Column(name="DATA_DATE")
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_date;
    @Column(name="ACTIVE")
    @ColumnDefault(value = "1")
    private Integer active;



}
