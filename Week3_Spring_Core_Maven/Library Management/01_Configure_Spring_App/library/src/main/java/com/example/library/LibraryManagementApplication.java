package com.example.library;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        try{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("Loading Booking Service");

        BookService bookService = context.getBean("bookService", BookService.class);

        System.out.println("Booking Service Loaded Successfully");

        }catch(Exception e){ 
            System.out.println("Unable to load Booking Service");
        }
    }
}
