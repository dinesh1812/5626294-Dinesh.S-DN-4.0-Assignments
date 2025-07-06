package com.cognizant.orm_learn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.util.HibernateUtil;

@SpringBootApplication
public class OrmLearnApplication {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = new Employee("John", "Doe", 50000);
        session.persist(emp);
        tx.commit();

        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list();
        list.forEach(System.out::println);

        Employee e = session.get(Employee.class, emp.getId());
        System.out.println("Get by ID: " + e);

        Transaction tx2 = session.beginTransaction();
        session.remove(e);
        tx2.commit();

        session.close();
        HibernateUtil.shutdown();
	}
}