package com.example.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/* Exercise 3 : Assertion in Junit */
public class BookTest {
    @Test
    public void testBookCreation(){
        Book book = new Book("Data Structures", "Dinesh", 400);
        assertEquals("Data Structures", book.getTitle());
        assertTrue(book.isBigBook());
    }

    @Test
    public void testSmallBook(){
        Book book = new Book("Fairy Tales", "John Doe", 100);
        assertFalse(book.isBigBook());
    }

    @Test
    void testInvalidTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Book("", "Author B", 200);
        });
        assertEquals("Title is required", e.getMessage());
    }

    @Test
    void testInvalidPages() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            new Book("Some Book", "Author C", 0);
        });
        assertEquals("Pages must be greater than 0", e.getMessage());
    }
}
