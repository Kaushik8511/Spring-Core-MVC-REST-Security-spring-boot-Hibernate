package com.mycompany.empdir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.empdir.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;

	// constructor injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// create query
		Query query = entityManager.createQuery("from Employee");

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee save(Employee employee) {
		// save or update the employee
		Employee emp = entityManager.merge(employee);

		// save the generated id and return
		employee.setId(emp.getId());

		return employee;
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId")
				.setParameter("employeeId", id);

		query.executeUpdate();

	}

}
