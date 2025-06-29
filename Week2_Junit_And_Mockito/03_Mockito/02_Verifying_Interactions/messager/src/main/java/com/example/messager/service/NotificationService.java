package com.example.messager.service;

import com.example.messager.model.MessageSender;

public class NotificationService {
    private MessageSender sender;

    public NotificationService(MessageSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String userEmail, String content) {
        sender.sendMessage(userEmail, content);
    }
}
