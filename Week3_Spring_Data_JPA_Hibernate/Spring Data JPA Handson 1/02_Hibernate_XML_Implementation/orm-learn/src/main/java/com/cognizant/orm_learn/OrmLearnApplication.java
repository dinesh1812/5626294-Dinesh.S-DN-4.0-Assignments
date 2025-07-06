package com.cognizant.orm_learn;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.util.HibernateUtil;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	public static void main(String[] args) {
		// CREATE
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee("John Doe", 30000);
        session.persist(emp); // session.persist()
        tx.commit();       // commit()

        // READ
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("from Employee", Employee.class).list(); // session.createQuery().list()
        list.forEach(System.out::println);

        // GET by ID
        Employee e = session.get(Employee.class, emp.getId()); // session.get()
        System.out.println("Get by ID: " + e);

        // DELETE
        Transaction tx2 = session.beginTransaction();
        session.remove(e); // session.remove()
        tx2.commit();

        session.close();
        HibernateUtil.shutdown();
	}
}
// SpringApplication.run(OrmLearnApplication.class, args);