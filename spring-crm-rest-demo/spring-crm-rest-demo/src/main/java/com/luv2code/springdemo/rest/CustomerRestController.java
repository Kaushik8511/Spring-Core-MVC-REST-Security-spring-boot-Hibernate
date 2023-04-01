package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	//get list of customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	//get customer by id
	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) throw new CustomerNotFoundException("customer not found");
		return customer;
	}
	
	//add a customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		//set id = 0 so in the back end it will not find customer with id 0.
		//force to save new customer instead of update.
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	//update the customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	//delete the customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		if(customer == null) throw new CustomerNotFoundException("Customer not found, can't delete");
		
		customerService.deleteCustomer(customerId);
		return "Deleted customer with id " + customerId;
	}
	
}
