package com.buddhi.multiplelibrary.membershipservice.service;

import com.buddhi.multiplelibrary.comman.models.membership.Membership;
import com.buddhi.multiplelibrary.membershipservice.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService{

    @Autowired
    MembershipRepository membershipRepository;

    @Override
    public Membership saveMembership(Membership membership) {

        return membershipRepository.save(membership);
    }
}
