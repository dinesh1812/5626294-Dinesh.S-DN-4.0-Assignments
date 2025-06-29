package com.example.logger.service;

import com.example.logger.model.LoggerClient;

public class LoggerService {
    private LoggerClient logger;

    public LoggerService(LoggerClient logger) {
        this.logger = logger;
    }

    public void logInfo(String message) {
        logger.log("INFO", message);
    }
}
