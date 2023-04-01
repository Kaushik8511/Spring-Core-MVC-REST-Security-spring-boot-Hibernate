package com.thymeleafspring.mythymeleaf.service;

import java.util.List;

import com.thymeleafspring.mythymeleaf.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public Employee save(Employee employee);
	
	public void deleteById(int id);
}
