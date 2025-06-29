package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderLogger {

    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLogger.class);

    public static void main(String[] args) {
        logger.info("Application started.");
        logger.debug("This is a debug-level message.");
        logger.warn("Warning! Something might need attention.");
        logger.error("Error occurred while executing the application.");

        simulateLogin("Dinesh", true);
        simulateLogin("John", false);

        logger.info("Application finished.");
    }

    private static void simulateLogin(String user, boolean success) {
        if (success) {
            logger.info("User '{}' logged in successfully.", user);
        } else {
            logger.warn("User '{}' failed to login.", user);
        }
    }
}