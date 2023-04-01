package com.thymeleafspring.mythymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymeleafspring.mythymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//That's it.. No need to write crud operations
	//it will all be provided by the spring
	//else you had to write entityManager.save() and all those methods
	
	//add a method to sort the list of employees
	//findAllBy* (* => query statement)
	public List<Employee> findAllByOrderByLastNameAsc();
}
