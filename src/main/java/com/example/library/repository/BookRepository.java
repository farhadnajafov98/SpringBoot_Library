package com.example.library.repository;

import com.example.library.entity.Book;
import com.example.library.request.RequestBook;
import com.example.library.response.ResponseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByActive(Integer active);

    Book findBookByIdAndActive(Long id, Integer active);

    List<Book> findAllByAuthorsAndActive(String author, Integer Active);
}
