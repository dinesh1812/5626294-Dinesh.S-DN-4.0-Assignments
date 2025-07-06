package com.cognizant.orm_learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Transactional
    public Department get(int id) {
        LOGGER.info("Start");
        return departmentRepository.findById(id).get();
    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Start Service");
        departmentRepository.save(department);
        LOGGER.info("End Service");
    }
}
