package com.thymeleafspring.mythymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thymeleafspring.mythymeleaf.model.Employee;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	private List<Employee> employees;
	
	@PostConstruct
	public void initiazer() {

		Employee employee = new Employee(1, "Kaushik", "Prajapati", "myemail.com");
		Employee employee1 = new Employee(1, "Chintan", "Vankar", "chintan.com");
		Employee employee2 = new Employee(1, "Kirtan", "Shah", "kirtan.com");
		
		employees = new ArrayList<Employee>();
		
		employees.add(employee);
		employees.add(employee1);
		employees.add(employee2);
		
		
	}
	
	//list of employees
		@GetMapping("/list")
		public String findAll(Model model) {
			
			model.addAttribute("employees", employees);
			return "employees-list";
		}
}
