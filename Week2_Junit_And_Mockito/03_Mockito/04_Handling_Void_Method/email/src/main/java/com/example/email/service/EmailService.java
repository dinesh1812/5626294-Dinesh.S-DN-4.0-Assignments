package com.example.email.service;

import com.example.email.model.EmailSender;

public class EmailService {
    private EmailSender sender;

    public EmailService(EmailSender sender) {
        this.sender = sender;
    }

    public void sendWelcomeEmail(String email) {
        sender.sendEmail(email, "Welcome!");
    }
}
