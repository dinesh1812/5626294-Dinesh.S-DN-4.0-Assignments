package com.example.demo;

public class ExceptionThrower {

    public void throwException(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        System.out.println("Valid input: " + input);
    }
}