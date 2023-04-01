package com.thymeleafspring.mythymeleaf.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thymeleafspring.mythymeleaf.entity.Employee;
import com.thymeleafspring.mythymeleaf.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// list of employees
	@GetMapping("/list")
	public String findAll(Model model) {
		
		List<Employee> employees = employeeService.findAll();
		
		model.addAttribute("employees", employees);
		
		return "employees/employees-list";
	}
	
	//show the form
	@GetMapping("/employee-form")
	public String showEmployeeForm(Model model) {
		//create model atttribute
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	//add the new employee or save the employee
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save the employee
		employeeService.save(employee);
		
		//use redirect to prevent duplication
		return "redirect:/employees/list";
	}
	
	//update the employee data
	@GetMapping("/update-form")
	public String showUpdateForm(@RequestParam("employeeId") int id, Model model) {
		//get employee from the service
		Employee employee = employeeService.findById(id);
		
		//set emp as model attribute
		model.addAttribute("employee", employee);
		
		//send over to our form
		return "employees/employee-form";
	}
	
	//delete the employee
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}
