package com.mycompany.empdir.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.empdir.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//That's it.. No need to write crud operations
	//it will all be provided by the spring
}
