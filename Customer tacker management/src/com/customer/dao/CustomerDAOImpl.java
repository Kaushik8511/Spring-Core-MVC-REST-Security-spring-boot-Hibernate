package com.customer.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		
		//get the list
		List<Customer> customers = query.getResultList();
		
		//return list of customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		//get the session
		Session session = sessionFactory.getCurrentSession();
		
		//delete using id
		session.createQuery("delete from Customer where id=:id").setParameter("id", id).executeUpdate();
		
	}

}
