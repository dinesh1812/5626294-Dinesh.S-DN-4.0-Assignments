package com.example.logger.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.logger.model.LoggerClient;

@ExtendWith(MockitoExtension.class)
public class LoggerServiceTest {

    @Mock
    private LoggerClient loggerClient;  // 1. Create a mock

    @InjectMocks
    private LoggerService loggerService;

    @Test
    public void testLogInfo_usesCorrectLogLevel() {
        // 2. Call the method with specific arguments
        loggerService.logInfo("System started");

        // 3. Use argument matchers to verify interaction
        verify(loggerClient).log(eq("INFO"), anyString());
    }
}
