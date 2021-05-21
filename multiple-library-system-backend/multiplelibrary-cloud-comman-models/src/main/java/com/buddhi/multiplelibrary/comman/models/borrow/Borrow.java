package com.buddhi.multiplelibrary.comman.models.borrow;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "borrow")
@NoArgsConstructor
@AllArgsConstructor
public class Borrow implements Serializable {

    private static final long serialVersionUID = 767958036359069705L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private Long libraryId;
    private Date borrowFrom;
    private Date borrowTill;
    private Long memberId;
    private Long membershipType;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getBorrowId() {
        return id;
    }

    public void setBorrowId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Date getBorrowFrom() {
        return borrowFrom;
    }

    public void setBorrowFrom(Date borrowFrom) {
        this.borrowFrom = borrowFrom;
    }

    public Date getBorrowTill() {
        return borrowTill;
    }

    public void setBorrowTill(Date borrowTill) {
        this.borrowTill = borrowTill;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(Long membershipType) {
        this.membershipType = membershipType;
    }
}