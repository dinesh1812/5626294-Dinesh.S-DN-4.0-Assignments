package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.cognizant.orm_learn.model.Country;

public interface CountryRepository extends JpaRepository<Country, String>{
    List<Country> findByNameContainingIgnoreCase(String name);
}