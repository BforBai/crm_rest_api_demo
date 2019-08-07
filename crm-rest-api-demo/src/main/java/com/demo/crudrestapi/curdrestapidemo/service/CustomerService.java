package com.demo.crudrestapi.curdrestapidemo.service;

import java.util.List;

import com.demo.crudrestapi.curdrestapidemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAll();
	
	public Customer getById(int theId);
	
	public void save(Customer theCustomer);
	
	public void delete(int theId);
	
}
