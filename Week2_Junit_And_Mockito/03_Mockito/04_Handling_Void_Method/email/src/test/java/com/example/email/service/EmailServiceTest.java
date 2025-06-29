package com.example.email.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.email.model.EmailSender;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private EmailSender emailSender;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSendWelcomeEmail() {
        // Stub void method
        doNothing().when(emailSender).sendEmail(anyString(), anyString());

        // Call method
        emailService.sendWelcomeEmail("test@example.com");

        // Verify interaction
        verify(emailSender).sendEmail(eq("test@example.com"), eq("Welcome!"));
    }
}
