package com.buddhi.multiplelibrary.borrowservice.repository;

import com.buddhi.multiplelibrary.comman.models.borrow.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
