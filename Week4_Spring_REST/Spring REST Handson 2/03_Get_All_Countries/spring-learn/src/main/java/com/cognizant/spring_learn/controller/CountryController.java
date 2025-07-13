package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getCountryIndia() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List <Country> countries = (List<Country>) context.getBean("countryList");
        return countries;
    }
}
