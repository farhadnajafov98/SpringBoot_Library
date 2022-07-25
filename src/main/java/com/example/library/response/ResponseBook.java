package com.example.library.response;

import com.example.library.entity.Author;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;
import lombok.Data;

import java.util.Set;

@Data
public class ResponseBook {
    private Long id;
    private String title;
    private Category category;
    private Publisher publisher;
    private Set<Author> author;
    private Long pages;
}
