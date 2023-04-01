package com.mycompany.empdir.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.empdir.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the hibernate session
		Session session = entityManager.unwrap(Session.class);

		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
		// get the session
		Session session = entityManager.unwrap(Session.class);

		// get the employee
		Employee employee = session.get(Employee.class, id);

		// return
		return employee;
	}

	@Override
	public Employee save(Employee employee) {
		// get the session
		Session session = entityManager.unwrap(Session.class);

		// save the employee
		session.saveOrUpdate(employee);

		// return employee
		return employee;
	}
 
	@Override
	public void deleteById(int id) {
		// get the session
		Session session = entityManager.unwrap(Session.class);

		// delete by id
		Query query = session.createQuery("delete from Employee where id=:employeeId")
				.setParameter("employeeId", id);
		
		
		
		query.executeUpdate();

	}

}
