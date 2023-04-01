package com.mycompany.empdir.dao;

import java.util.List;

import com.mycompany.empdir.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee);
	
	public void deleteById(int id);
	
}
