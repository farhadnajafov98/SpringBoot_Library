package com.example.library.service.impl;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.entity.Category;
import com.example.library.entity.Publisher;
import com.example.library.enums.EnumAvaliableStatus;
import com.example.library.exceptions.ExceptionsConstant;
import com.example.library.exceptions.LibraryException;
import com.example.library.repository.BookRepository;
import com.example.library.request.RequestBook;
import com.example.library.response.Response;
import com.example.library.response.ResponseBook;
import com.example.library.response.ResponseStatus;
import com.example.library.response.ResponseStatusList;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Response<List<ResponseBook>> getBookList() {
        Response<List<ResponseBook>> response = new Response<>();
        try {
            List<Book> books = bookRepository.findAllByActive(EnumAvaliableStatus.ACTIVE.getValue());
            if (books == null) {
                throw new LibraryException(ExceptionsConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");
            }

            List<ResponseBook> responseBookList = new ArrayList();
            for (Book book : books) {
                ResponseBook responseBook = new ResponseBook();
                responseBook.setId(book.getId());
                responseBook.setTitle(book.getTitle());
                responseBook.setCategory(book.getCategory());
                responseBook.setPublisher(book.getPublisher());
                responseBook.setAuthor(book.getAuthors());
                responseBook.setPages(book.getPages());
                responseBookList.add(responseBook);
                response.setT(responseBookList);
                response.setStatus(ResponseStatus.getSuccessMessage());


            }
        } catch (LibraryException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));

        } catch (Exception ex) {
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public Response<ResponseBook> getBookById(Long bookId) {
        Response<ResponseBook> response = new Response<>();
        try {
            if (bookId == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");

            }
            Book book = bookRepository.findBookByIdAndActive(bookId, EnumAvaliableStatus.ACTIVE.getValue());
            if (book == null) {
                throw new LibraryException(ExceptionsConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");
            }
            ResponseBook responseBook = new ResponseBook();
            responseBook.setId(bookId);
            responseBook.setTitle(book.getTitle());
            responseBook.setCategory(book.getCategory());
            responseBook.setPublisher(book.getPublisher());
            responseBook.setAuthor(book.getAuthors());
            responseBook.setPages(book.getPages());
            response.setT(responseBook);
            response.setStatus(ResponseStatus.getSuccessMessage());

        } catch (LibraryException exx) {
            response.setStatus(new ResponseStatus(exx.getCode(), exx.getMessage()));
        } catch (Exception exx) {
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public ResponseStatusList addBook(RequestBook requestBook) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long Id = requestBook.getId();
            String title = requestBook.getTitle();
            Category category = requestBook.getCategory();
            Publisher publisher = requestBook.getPublisher();
            Set<Author> author = requestBook.getAuthor();
            Long pages = requestBook.getPages();

            if (Id == null || title == null || category == null || publisher == null || author == null || pages == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");

            }
            Book book = new Book();
            book.setId(Id);
            book.setTitle(title);
            book.setCategory(category);
            book.setPublisher(publisher);
            book.setAuthors(author);
            book.setPages(pages);
            bookRepository.save(book);
            response.setStatus(ResponseStatus.getSuccessMessage());

        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));

        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));

        }


        return response;
    }

    @Override
    public ResponseStatusList updateBook(RequestBook requestBook) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            Long Id = requestBook.getId();
            String title = requestBook.getTitle();
            Category category = requestBook.getCategory();
            Publisher publisher = requestBook.getPublisher();
            Set<Author> author = requestBook.getAuthor();
            Long pages = requestBook.getPages();
            if (Id == null || title == null || category == null || publisher == null || author == null || pages == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");

            }
            Book book = bookRepository.findBookByIdAndActive(requestBook.getId(), EnumAvaliableStatus.ACTIVE.getValue());
            if (book == null) {
                throw new LibraryException(ExceptionsConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");
            }
            book.setId(Id);
            book.setTitle(title);
            book.setCategory(category);
            book.setPublisher(publisher);
            book.setAuthors(author);
            book.setPages(pages);
            bookRepository.save(book);
            response.setStatus(ResponseStatus.getSuccessMessage());

        } catch (LibraryException ex) {
            response.setStatus(new ResponseStatus(ex.getCode(), ex.getMessage()));

        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }

        return null;
    }

    @Override
    public ResponseStatusList deleteBook(Long bookId) {
        ResponseStatusList response = new ResponseStatusList();
        try {
            if (bookId == null) {
                throw new LibraryException(ExceptionsConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Book book = bookRepository.findBookByIdAndActive(bookId, EnumAvaliableStatus.ACTIVE.getValue());
            if (book == null) {
                throw new LibraryException(ExceptionsConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");
            }
            book.setActive(EnumAvaliableStatus.DEACTIVE.getValue());
            bookRepository.save(book);
            response.setStatus(ResponseStatus.getSuccessMessage());

        } catch (LibraryException ex) {
            response.setStatus(ResponseStatus.getSuccessMessage());
        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new ResponseStatus(ExceptionsConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public Response<List<ResponseBook>> getBookListByTitle(String title) {

        return null;
    }
}
