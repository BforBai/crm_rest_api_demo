package com.demo.crmrestclient.service;

import java.util.List;

import com.demo.crmrestclient.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAll();
	
	public Customer getById(int theID);
	
	public void updateCustomer(Customer theCustomer);
	
	public void deleteCustomer(Customer theCustomer);
	
	public void addCustomer(Customer theCustomer);
	
}
