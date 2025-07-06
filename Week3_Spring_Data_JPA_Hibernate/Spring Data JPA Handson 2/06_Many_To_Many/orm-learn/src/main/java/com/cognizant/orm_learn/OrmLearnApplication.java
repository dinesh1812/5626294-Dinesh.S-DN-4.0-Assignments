package com.cognizant.orm_learn;

import java.sql.Date;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Skill;
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

        //testGetEmployee();
        testAddSkillToEmployee();

        //testGetDepartment();

        //testAddEmployee();
        //testUpdateEmployee();
	}

    /* Skill Many To Many */
    private static void testAddSkillToEmployee() {
    LOGGER.info("Start");

    Employee employee = employeeService.get(1); // choose an existing employee
    Skill skill = skillService.get(2);          // choose an existing skill

    Set<Skill> skills = employee.getSkillList();
    skills.add(skill);
    employee.setSkillList(skills);

    employeeService.save(employee);

    LOGGER.debug("Updated Employee with Skills: {}", employee);
    LOGGER.info("End");
}
    /* Department One To Many */
    private static void testGetDepartment() {
    LOGGER.info("Start");
    Department department = departmentService.get(1); // change id based on your DB
    LOGGER.debug("Department: {}", department);
    LOGGER.debug("Employee List: {}", department.getEmployeeList());
    LOGGER.info("End");
}

    /* Employee Many To One */
	private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.info("End");
    }
    
    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("New Emp");
        employee.setSalary(80000);
        employee.setPermanent(true);
        employee.setDateOfBirth(Date.valueOf("1990-01-01"));
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Employee Added: {}", employee);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2); // use a different department
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Employee Updated: {}", employee);
        LOGGER.info("End");
    }
}
