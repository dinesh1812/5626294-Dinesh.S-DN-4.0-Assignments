package com.cognizant.spring_learn;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Main method");
        displayDate();
        LOGGER.info("Closing Main method");
    }

    public static void displayDate() {
        LOGGER.info("Starting Display Date");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

        try {
            Date date = format.parse("08/07/2025");
            System.out.println("Parsed Date: " + date);
        } catch (Exception e) {
            System.err.println("Date parsing failed: " + e.getMessage());
        }
        LOGGER.info("Closing Display Date");
    }
}
