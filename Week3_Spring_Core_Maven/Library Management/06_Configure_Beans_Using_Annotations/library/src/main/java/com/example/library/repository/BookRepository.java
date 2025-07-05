package com.example.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public String getBook() {
        return "Spring Core And Maven";
    }
}