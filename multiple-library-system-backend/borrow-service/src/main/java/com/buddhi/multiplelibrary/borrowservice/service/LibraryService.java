package com.buddhi.multiplelibrary.borrowservice.service;

import com.buddhi.multiplelibrary.comman.models.borrow.Library;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LibraryService {

    Library createLibrary(Library library);


}
