package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;


@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static EmployeeService employeeService;
    private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetAverageSalary();
	}

    public static void testGetAverageSalary() {
        LOGGER.info("Start");
        double avgSalary = employeeService.getAverageSalary(1); // pass department ID
        LOGGER.debug("Average Salary in Department 1: {}", avgSalary);
        LOGGER.info("End");
    }
}