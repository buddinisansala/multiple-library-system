package com.buddhi.multiplelibrary.borrowservice.repository;

import com.buddhi.multiplelibrary.comman.models.borrow.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
//    public List<Book> findAllBy(String bookId);
    List<Book> findBookByIdAndBookStatusTrue    (Long bookID);
}
