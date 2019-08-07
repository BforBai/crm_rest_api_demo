package com.demo.crudrestapi.curdrestapidemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.crudrestapi.curdrestapidemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private EntityManager entityManager;
	
	public CustomerDAOImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Customer> getAll() {
		
		Query theQuery = entityManager.createQuery("from Customer");
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public Customer getById(int theId) {
		
		//get employee 
		Customer theCustomer = entityManager.find(Customer.class, theId);
		
		
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		
		Customer customer = entityManager.merge(theCustomer);
		
		theCustomer.setId(customer.getId());

	}

	@Override
	public void delete(int theId) {
		
		Query theQuery = entityManager.createQuery("delete from Customer where id=:customerID");
		
		theQuery.setParameter("customerID", theId);
		
		theQuery.executeUpdate();

	}

}
