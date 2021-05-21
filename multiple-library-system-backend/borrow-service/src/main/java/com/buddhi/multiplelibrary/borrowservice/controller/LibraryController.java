package com.buddhi.multiplelibrary.borrowservice.controller;

import com.buddhi.multiplelibrary.borrowservice.service.LibraryService;
import com.buddhi.multiplelibrary.comman.models.borrow.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    @ResponseBody
    public String welcome() {
        return ("Welcome to Library.");
    }

    @PostMapping("/library")
    public ResponseEntity<Object> createLibrary(@RequestBody Library library) {
        libraryService.createLibrary(library);
        return  ResponseEntity.ok().body("Library Created");
    }
}
