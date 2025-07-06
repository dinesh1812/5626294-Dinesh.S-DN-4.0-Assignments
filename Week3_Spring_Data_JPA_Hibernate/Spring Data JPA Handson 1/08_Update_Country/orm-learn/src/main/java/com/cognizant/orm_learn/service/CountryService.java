package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

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
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    /* In this Exercise, Im going to Implement updateCountry which updates the country data*/
    @Transactional
    public Country findCountryByCode(String code) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);
        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found.");
        }
        return result.get();
    }

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> optionalCountry = countryRepository.findById(code);
        if (!optionalCountry.isPresent()) {
            throw new CountryNotFoundException("Country with code " + code + " not found.");
        }
        Country country = optionalCountry.get();
        country.setName(name);
        countryRepository.save(country);
    }

    @Transactional
    public void deleteCountry(String code) {
    }

    @Transactional
    public List<Country> findCountriesByPartialName(String partialName) {
        return null;
    }
}
