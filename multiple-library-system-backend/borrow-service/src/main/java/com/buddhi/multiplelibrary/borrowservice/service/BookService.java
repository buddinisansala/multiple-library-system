package com.buddhi.multiplelibrary.borrowservice.service;

import com.buddhi.multiplelibrary.comman.models.borrow.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    Book createBook(Book book);

    List<Book> getBooks();

    Optional<Book> getBookById(Long bookId);

    Optional<Book> findById(Long bookId);

    void deleteBook(Book book);

    Book updateBook(Book book);

    boolean findBookByIdAndBookStatusTrue(Long bookId);
}
