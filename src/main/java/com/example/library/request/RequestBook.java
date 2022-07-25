package com.example.library.request;

import com.example.library.entity.Author;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;
import lombok.Data;

import java.util.Set;
@Data
public class RequestBook {
    private Long id;
    private String title;
    private Category category;
    private Publisher publisher;
    private Set<Author> author;
    private Long pages;
}
