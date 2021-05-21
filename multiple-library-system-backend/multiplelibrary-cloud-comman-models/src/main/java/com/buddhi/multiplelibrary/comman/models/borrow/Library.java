package com.buddhi.multiplelibrary.comman.models.borrow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "library")
@AllArgsConstructor
@NoArgsConstructor
public class Library implements Serializable {

    private static final long serialVersionUID = 767958036359069705L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long libraryId;
    private String libraryName;
    private String location;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

