package com.example.library.controller;

import com.example.library.request.RequestBook;
import com.example.library.response.Response;
import com.example.library.response.ResponseBook;

import com.example.library.response.ResponseStatusList;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(value = "/bookList")
    public Response<List<ResponseBook>> getBookList() {
        return bookService.getBookList();
    }

    @PostMapping(value = "/getBookList")
    public Response<ResponseBook> getBookListById(@RequestParam Long bookId) {
        return bookService.getBookById(bookId);

    }

    @PostMapping(value = "/addBook")
    public ResponseStatusList addBook(@RequestBody RequestBook requestBook) {
        return bookService.addBook(requestBook);
    }

    @PutMapping(value = "/updateBook")
    public ResponseStatusList updateBook(@RequestBody RequestBook requestBook) {
        return bookService.updateBook(requestBook);
    }

    @PutMapping(value = "/delete/{bookId}")
    public ResponseStatusList deleteBook(@PathParam("bookId") Long bookId) {
        return bookService.deleteBook(bookId);
    }
}
