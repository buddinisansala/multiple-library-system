package com.buddhi.multiplelibrary.borrowservice.service;

import com.buddhi.multiplelibrary.borrowservice.repository.BookRepository;
import com.buddhi.multiplelibrary.comman.models.borrow.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long bookId){
        return bookRepository.findById(bookId);
    }

    @Override
    public Optional<Book> findById(Long bookId){
        return bookRepository.findById(bookId);
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

    @Override
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public boolean findBookByIdAndBookStatusTrue(Long bookId){
        bookRepository.findBookByIdAndBookStatusTrue(bookId);
        return true;
    }

}
