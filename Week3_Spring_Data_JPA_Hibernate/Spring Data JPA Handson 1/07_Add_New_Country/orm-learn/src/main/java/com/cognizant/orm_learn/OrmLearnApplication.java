package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryNotFoundException;
import com.cognizant.orm_learn.service.CountryService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");
    }

    private void getCountryByCode() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("XX");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End");
    }

    @PostConstruct
    private void testAddCountry() {
        LOGGER.info("Start");

        Country newCountry = new Country("ZZ", "Zetaland");
        countryService.addCountry(newCountry);

        try {
            Country fetched = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added Country: {}", fetched);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after add: {}", e.getMessage());
        }

        LOGGER.info("End");
    }

}
