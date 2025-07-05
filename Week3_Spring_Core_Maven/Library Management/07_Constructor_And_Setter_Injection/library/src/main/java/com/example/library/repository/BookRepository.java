package com.example.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public String getBook(int id) {
        if(id == 1){
            return "Advance Java Programming";
        }
        if(id == 2){
            return "Data Structures and Algorithms";
        }
        else{
            return "Invalid Book ID";
        }
    }
}