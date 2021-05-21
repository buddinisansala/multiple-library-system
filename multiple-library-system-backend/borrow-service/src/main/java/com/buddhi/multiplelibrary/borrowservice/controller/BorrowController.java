package com.buddhi.multiplelibrary.borrowservice.controller;

import com.buddhi.multiplelibrary.borrowservice.service.BorrowService;
import com.buddhi.multiplelibrary.comman.models.borrow.Book;
import com.buddhi.multiplelibrary.comman.models.borrow.Borrow;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private BookController bookController;

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET
    )
    @ResponseBody
    public String welcome() {
        return ("Welcome to Borrows.");
    }

    @PostMapping("/borrow")
    public ResponseEntity<Object> createBorrow(@RequestBody Borrow borrow) throws NotFoundException {
        if(bookController.getBookStatus(borrow.getBookId())){
            borrowService.createBorrow(borrow);
            bookController.updateStatusBook(borrow.getBookId());
            return ResponseEntity.ok().body("Borrows Created");
        }else{
            return ResponseEntity.badRequest().body("Book was borrowed already");
        }

    }

    @RequestMapping(
            value = "/borrows",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public JSONObject getBorrows() throws NotFoundException {
        List<Borrow> list = borrowService.getBorrows();
        return jsonCreate(list);
    }


    @GetMapping("/borrow-member/{memberID}")
    public JSONObject getBorrowsByMemeberId(@PathVariable(value = "memberID") Long memberID)
            throws IllegalArgumentException, NotFoundException {

        List<Borrow> list = borrowService.getBorrowsByMemeberId(memberID);
        return jsonCreate(list);
    }

    private JSONObject jsonCreate(List<Borrow> list) throws NotFoundException {
        JSONObject full_details = new JSONObject();
        JSONArray final_arr = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            Borrow b = list.get(i);
            Book bookList = bookController.getBookById(b.getBookId());
            JSONObject details = new JSONObject();
            details.put("borrow-details", b);
            details.put("book-details", bookList);
            final_arr.add(details);

        }
        full_details.put("data",final_arr);
        return full_details;
    }

}
