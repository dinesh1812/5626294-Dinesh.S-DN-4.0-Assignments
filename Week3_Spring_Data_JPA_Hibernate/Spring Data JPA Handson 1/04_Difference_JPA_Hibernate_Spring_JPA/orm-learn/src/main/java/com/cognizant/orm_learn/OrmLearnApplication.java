package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import jakarta.annotation.PostConstruct;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class OrmLearnApplication {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    // Run some test code after startup
	@PostConstruct
    public void testSave() {
        Employee e1 = new Employee("Hibernate", "Manual");
        Integer id = employeeService.addEmployeeWithHibernate(e1);
        System.out.println("Hibernate saved employee ID: " + id);

        Employee e2 = new Employee("SpringData", "JPA");
        employeeService.addEmployeeWithSpringData(e2);
        System.out.println("Spring Data JPA saved employee");
    }
}