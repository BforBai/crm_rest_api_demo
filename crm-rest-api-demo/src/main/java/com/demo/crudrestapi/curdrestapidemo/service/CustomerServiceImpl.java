package com.demo.crudrestapi.curdrestapidemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.crudrestapi.curdrestapidemo.dao.CustomerDAO;
import com.demo.crudrestapi.curdrestapidemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl(CustomerDAO theCustomerDAO) {
		customerDAO = theCustomerDAO;
	}
	
	@Override
	@Transactional
	public List<Customer> getAll() {
		
		return customerDAO.getAll();
	}

	@Override
	@Transactional
	public Customer getById(int theId) {
		// TODO Auto-generated method stub
		return customerDAO.getById(theId);
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		
		customerDAO.save(theCustomer);

	}

	@Override
	@Transactional
	public void delete(int theId) {
		
		customerDAO.delete(theId);

	}

}
