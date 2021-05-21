package com.buddhi.multiplelibrary.membershipservice.service;

import com.buddhi.multiplelibrary.comman.models.membership.Membership;
import org.springframework.stereotype.Service;

@Service
public interface MembershipService {

    Membership saveMembership(Membership membership);
}
