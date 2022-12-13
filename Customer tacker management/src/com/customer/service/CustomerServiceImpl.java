package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.dao.CustomerDAO;
import com.customer.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	//inject dependency (customer DAO - will get data from DAO)
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		//save using DAO
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);		
	}

}
