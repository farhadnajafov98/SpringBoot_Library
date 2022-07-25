package com.example.library.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import com.example.library.entity.Category;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Book")
@DynamicInsert
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name="CATEGORY_ID", nullable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name="PUBLISHER_ID", nullable = false)
    private Publisher publisher;
    @ManyToMany
    @Column(name="AUTHOR_ID")
    private Set<Author> authors;
    @Column(name="PAGES")
    private Long pages;
    @Column(name="DATA_DATE")
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_date;
    @Column(name="ACTIVE")
    @ColumnDefault(value = "1")
    private Integer active;


}
