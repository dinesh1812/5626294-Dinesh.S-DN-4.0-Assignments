package com.example.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("=== Constructor Injection ===");
        BookService constructor = (BookService) context.getBean("bookServiceConstructor");
        constructor.displayBook(1);

        System.out.println("=== Setter Injection ===");
        BookService setter = (BookService) context.getBean("bookServiceSetter");
        setter.displayBook(2);
    }
}

/* NOTE: Spring allows only one method of Injection per Bean. 
 * So, I am using two different Beans for Constructor and Setter Injections
 */