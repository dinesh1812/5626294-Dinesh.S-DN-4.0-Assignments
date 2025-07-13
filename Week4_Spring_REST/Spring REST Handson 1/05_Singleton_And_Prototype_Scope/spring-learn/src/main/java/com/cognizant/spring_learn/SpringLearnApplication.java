package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Main method");
        // Singleton
        //displayCountrySingleton();
        
        // Prototyoe
        displayCountryPrototype();
        LOGGER.info("Closing Main method");
    }

    public static void displayCountrySingleton() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // Creating country object using Singleton Scope
        Country country = context.getBean("country1", Country.class);
        Country anotherCountry = context.getBean("country1", Country.class);

        LOGGER.info("Country : {}", country);
        LOGGER.info("Another Country : {}", anotherCountry);
        // Both the objects will be equal
        LOGGER.info("Same object ? {}", country == anotherCountry);
    }

    public static void displayCountryPrototype() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        // Creating country object using Prototype Scope
        Country country = context.getBean("country2", Country.class);
        Country anotherCountry = context.getBean("country2", Country.class);

        LOGGER.info("Country : {}", country);
        LOGGER.info("Another Country : {}", anotherCountry);
        // Both the objects will be equal
        LOGGER.info("Same object ? {}", country == anotherCountry);
    }
}