package com.buddhi.multiplelibrary.borrowservice.service;

import com.buddhi.multiplelibrary.borrowservice.repository.BorrowRepository;
import com.buddhi.multiplelibrary.comman.models.borrow.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public Borrow createBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    @Override
    public List<Borrow> getBorrows(){
        return borrowRepository.findAll();
    }

    @Override
    public List<Borrow> getBorrowsByMemeberId(Long memberID){
        return borrowRepository.findAllByMemberId(memberID);
    }

}

