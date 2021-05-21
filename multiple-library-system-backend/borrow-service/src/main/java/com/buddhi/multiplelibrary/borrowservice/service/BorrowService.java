package com.buddhi.multiplelibrary.borrowservice.service;

import com.buddhi.multiplelibrary.comman.models.borrow.Borrow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowService {

    Borrow createBorrow(Borrow borrow);

    List<Borrow> getBorrows();

    List<Borrow> getBorrowsByMemeberId(Long memberID);
}
