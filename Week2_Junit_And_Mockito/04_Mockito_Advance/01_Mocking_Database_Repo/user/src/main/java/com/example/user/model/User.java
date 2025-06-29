package com.example.user.model;

public class User {
    private Long id;
    private String name;

    // Constructors, Getters, Setters
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
}