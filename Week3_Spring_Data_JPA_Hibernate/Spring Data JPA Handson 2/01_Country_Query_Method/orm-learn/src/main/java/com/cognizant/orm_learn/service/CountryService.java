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
        if (countryRepository.existsById(code)) {
            countryRepository.deleteById(code);
        }
    }

    @Transactional
    public List<Country> searchByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }

    @Transactional
    public List<Country> searchByPartialNameSorted(String partialName) {
        return countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc(partialName);
    }

    @Transactional
    public List<Country> searchByFirstAlphabet(String alphabet) {
        return countryRepository.findByNameStartingWithIgnoreCaseOrderByNameAsc(alphabet);
    }
}