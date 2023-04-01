package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the dao
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		//get the customers from DAO
		List<Customer> customers = customerService.getCustomers();
		
		//add them to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/show-form-for-add")
	public String showFormForAdd(Model model) {
		
		//create model attribute to bind the data
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form"; 
	}
	
	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		//save the service using customer service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/update-customer-form")
	public String updateCustomerForm(@RequestParam("customerId") int id, Model model) {
		
		//get the customer from database
		Customer customer = customerService.getCustomer(id);
		
		//set customer as a model attribute
		model.addAttribute("customer", customer);
		
		
		//return form with model
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
		
		//delete the customer
		customerService.deleteCustomer(id);
		
		return  "redirect:/customer/list";
	}

}
