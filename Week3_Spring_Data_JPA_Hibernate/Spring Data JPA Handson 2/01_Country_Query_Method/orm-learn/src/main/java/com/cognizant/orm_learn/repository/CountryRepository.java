package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.cognizant.orm_learn.model.Country;


/* In this project, Im going to implement Query Methods For Country Service */
public interface CountryRepository extends JpaRepository<Country, String>{

    /* 1. Search By Partial Name */
    List<Country> findByNameContainingIgnoreCase(String partialName);

    /* 2. Search By Patial Name - Sorted */
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String partialName);
    
    /* 3. Search By First Alphabet */
    List<Country> findByNameStartingWithIgnoreCaseOrderByNameAsc(String alphabet);
}