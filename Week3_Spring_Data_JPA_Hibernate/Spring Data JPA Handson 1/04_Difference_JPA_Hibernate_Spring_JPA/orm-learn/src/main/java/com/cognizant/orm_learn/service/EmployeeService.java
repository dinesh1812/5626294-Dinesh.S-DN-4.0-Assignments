package com.cognizant.orm_learn.service;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.transaction.Transactional;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private SessionFactory sessionFactory;

    // For Spring Data JPA
    @Autowired
    private EmployeeRepository employeeRepository;

    // Manual Hibernate save method (returns generated ID)
    public Integer addEmployeeWithHibernate(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    // Spring Data JPA save method
    @Transactional
    public void addEmployeeWithSpringData(Employee employee) {
        employeeRepository.save(employee);
    }
}
