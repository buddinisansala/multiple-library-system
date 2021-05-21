package com.buddhi.multiplelibrary.membershipservice.repository;

import com.buddhi.multiplelibrary.comman.models.membership.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long> {

//    Membership save(Membership membership) throws JpaSystemException;
}
