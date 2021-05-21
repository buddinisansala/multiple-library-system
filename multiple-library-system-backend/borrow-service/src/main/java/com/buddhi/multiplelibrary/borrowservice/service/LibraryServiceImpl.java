package com.buddhi.multiplelibrary.borrowservice.service;

import com.buddhi.multiplelibrary.borrowservice.repository.LibraryRepository;
import com.buddhi.multiplelibrary.comman.models.borrow.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public Library createLibrary(Library library){
        return libraryRepository.save(library);
    }

}
