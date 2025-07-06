package com.cognizant.orm_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    /* Now we are going to decalre the methods alone. In the later Assignments , I will implement the methods accordingly
     * This project is created based on the first project of Country Management.
     * In this porject, Im going to populate the database.
     */

     @Transactional
    public Country findCountryByCode(String code) {
        return null;
    }

    @Transactional
    public void addCountry(Country country) {
    }

    @Transactional
    public void updateCountry(Country country) {
    }

    @Transactional
    public void deleteCountry(String code) {
    }

    @Transactional
    public List<Country> findCountriesByPartialName(String partialName) {
        return null;
    }
}
