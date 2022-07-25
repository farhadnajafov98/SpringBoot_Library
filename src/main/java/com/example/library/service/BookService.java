package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.request.RequestBook;
import com.example.library.response.Response;
import com.example.library.response.ResponseBook;
import com.example.library.response.ResponseStatus;
import com.example.library.response.ResponseStatusList;

import java.util.List;

public interface BookService {

    Response<List<ResponseBook>>getBookList();
    Response<ResponseBook>getBookById(Long bookId);
    ResponseStatusList addBook(RequestBook requestBook);
    ResponseStatusList updateBook(RequestBook requestBook);
    ResponseStatusList deleteBook(Long bookId);
    Response<List<ResponseBook>>getBookListByTitle(String title);
}
