package com.cognizant.spring_learn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Main method");
        displayCountries();
        LOGGER.info("Closing Main method");
    }

    public static void displayCountries() {
        LOGGER.info("START - displayCountries()");

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countryList = context.getBean("countryList", ArrayList.class);

        for (Country country : countryList) {
            LOGGER.info("Country: {}", country);
        }

        LOGGER.info("END - displayCountries()");
    }
}
