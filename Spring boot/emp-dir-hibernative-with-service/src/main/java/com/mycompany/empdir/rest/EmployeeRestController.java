package com.mycompany.empdir.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.empdir.entity.Employee;
import com.mycompany.empdir.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//constructor injection
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//get list of all employees
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}
	
	//get employee by id
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if(employee == null) throw new RuntimeException("Employee not found by id!!!");
		return employee;
	}
	
	//save the employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		return employeeService.save(employee);
	}
	
	//update the employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		Employee tempEmployee = employeeService.findById(employee.getId());
		if(tempEmployee == null) throw new Error("Cant update!! employee not found");
		
		return employeeService.save(employee);
	}
	
	//delete the employee
	@DeleteMapping("/employees/{employeeId}")
	public Employee deleteById(@PathVariable int employeeId) {

		Employee tempEmployee = employeeService.findById(employeeId);
		if(tempEmployee == null) throw new Error("Cant delete!! employee not found");
		
		employeeService.deleteById(employeeId);
		
		return tempEmployee;
	}
	
}
