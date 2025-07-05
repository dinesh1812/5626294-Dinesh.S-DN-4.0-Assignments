package com.example.library.service;

import org.springframework.stereotype.Service;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    private BookRepository bookRepository;

    // Default Constructor
    public BookService(){

    }

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter for Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
}

    public void displayBook(int id){
        System.out.println("Book: "+ bookRepository.getBook(id));
    }
}
