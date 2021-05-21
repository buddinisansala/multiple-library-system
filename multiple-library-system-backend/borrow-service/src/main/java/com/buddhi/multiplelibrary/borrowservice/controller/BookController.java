package com.buddhi.multiplelibrary.borrowservice.controller;

import com.buddhi.multiplelibrary.borrowservice.service.BookService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import com.buddhi.multiplelibrary.borrowservice.repository.BookRepository;
import com.buddhi.multiplelibrary.comman.models.borrow.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    @ResponseBody
    public String welcome() {
        return ("Welcome to Books.");
    }

    @PostMapping("/book")
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return  ResponseEntity.ok().body("Book Created");
    }

    @RequestMapping(
            value = "/books",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public List<Book> getBooks() {
        List<Book> list = bookService.getBooks();
        return list;
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId)
            throws IllegalArgumentException {
        return bookService.getBookById(bookId)
                .orElseThrow(() -> new com.buddhi.multiplelibrary.borrowservice.errors.NotFoundException(String.format("Book not found for this id :: " + bookId)));
    }


    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") Long bookId)
            throws IllegalArgumentException, NotFoundException {
        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new NotFoundException(String.format("Book not found for this id :: " + bookId)));

        bookService.deleteBook(book);
        return ResponseEntity.ok().body("Book Deleted");
    }

    @PutMapping("/book/{id}")
    public ResponseEntity <Book> updateBook(@PathVariable(value = "id") Long bookId,
                                            @RequestBody Book bookDetails) throws IllegalArgumentException {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new com.buddhi.multiplelibrary.borrowservice.errors.NotFoundException(String.format("Book not found for this id :: " + bookId))
                );

        book.setAuthor(bookDetails.getAuthor());
        book.setBookCategory(bookDetails.getBookCategory());
        book.setBookName(bookDetails.getBookName());
        book.setBookPrice(bookDetails.getBookPrice());
        book.setBookStatus(bookDetails.getBookStatus());
        book.setLibraryId(bookDetails.getLibraryId());
        final Book updatedEmployee = bookRepository.save(book);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/book-borrow/{id}")
    public ResponseEntity <Book> updateStatusBook(@PathVariable(value = "id") Long bookId,
                                            @RequestBody Book bookDetails) throws IllegalArgumentException {

        Book book = bookService.findById(bookId)
                .orElseThrow(() ->
                        new com.buddhi.multiplelibrary.borrowservice.errors.NotFoundException(String.format("Book not found for this id :: " + bookId))
                );
        book.setBookStatus(bookDetails.getBookStatus());
        final Book updatedEmployee = bookService.updateBook(book);
        return ResponseEntity.ok(updatedEmployee);
    }

    public void updateStatusBook(Long bookId) {
        Book book = bookService.findById(bookId)
                .orElseThrow(() ->
                        new com.buddhi.multiplelibrary.borrowservice.errors.NotFoundException(String.format("Book not found for this id :: " + bookId))
                );
        book.setBookStatus(Boolean.FALSE);
        bookService.updateBook(book);
    }

    public boolean getBookStatus(Long bookId) throws NotFoundException {
        Book book = bookService.findById(bookId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Book not found for this id :: " + bookId))
                );
        System.out.println(bookService.findBookByIdAndBookStatusTrue(bookId));
        if(bookRepository.findBookByIdAndBookStatusTrue(bookId).size()>0){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }

    }


}
