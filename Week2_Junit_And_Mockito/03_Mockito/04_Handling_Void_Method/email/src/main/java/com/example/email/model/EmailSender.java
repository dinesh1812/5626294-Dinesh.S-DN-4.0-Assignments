package com.example.email.model;

public interface EmailSender {
    void sendEmail(String to, String body);
}