package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingApp {
    private static final Logger logger = LoggerFactory.getLogger(LoggingApp.class);

    public static void main(String[] args) {
        logger.info("Starting the application...");

        try {
            divide(10, 0);
        } catch (Exception e) {
            logger.error("Exception occurred: {}", e.getMessage(), e);
        }

        logger.warn("This is a warning after error.");
        logger.info("Application finished.");
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}
