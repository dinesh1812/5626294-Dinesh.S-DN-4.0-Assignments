package com.example.messager.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.messager.model.MessageSender;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    private MessageSender messageSender;  // 1. Create mock

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void testNotifyUser_sendsCorrectMessage() {
        // 2. Call the method
        notificationService.notifyUser("user@example.com", "Welcome!");

        // 3. Verify the interaction
        verify(messageSender).sendMessage("user@example.com", "Welcome!");
    }
}
