package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogger {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogger.class);

    public static void main(String[] args) {
        String user = "Dinesh";
        int userId = 1001;
        double balance = 2450.75;

        logger.info("User {} with ID {} has a balance of Rs. {}", user, userId, balance);

        int a = 5, b = 0;
        try {
            int result = a / b;
        } catch (ArithmeticException ex) {
            logger.error("Error dividing {} by {}: {}", a, b, ex.toString());
        }
    }
}