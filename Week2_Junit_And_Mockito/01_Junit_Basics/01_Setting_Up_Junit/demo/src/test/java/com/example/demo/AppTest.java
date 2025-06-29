package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/* Exercise 1 : Setting Up Junit */  

public class AppTest 
{
    @Test
    void testApp() {
        assertEquals("Hello, Dinesh", App.printHello("Dinesh"));
    }
}

