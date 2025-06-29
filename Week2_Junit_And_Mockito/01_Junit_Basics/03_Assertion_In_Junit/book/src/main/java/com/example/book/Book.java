package com.example.book;

public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title is required");
        if (pages <= 0) throw new IllegalArgumentException("Pages must be greater than 0");
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBigBook() {
        return pages > 300;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }
}
