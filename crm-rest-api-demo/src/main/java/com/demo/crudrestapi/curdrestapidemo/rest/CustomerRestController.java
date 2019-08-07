package com.demo.crudrestapi.curdrestapidemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crudrestapi.curdrestapidemo.entity.Customer;
import com.demo.crudrestapi.curdrestapidemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerRestController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return customerService.getAll();
	}
	
	@GetMapping("customers/{customerID}")
	public Customer getById(@PathVariable("customerID") int theID) {
		
		return customerService.getById(theID);
	}
	
	@PostMapping("/customers")
	public String addCustomer(@RequestBody Customer customer) {
		
		customer.setId(0);
		
		customerService.save(customer);
		
		return "Success!";
	}
	
	@PutMapping("/customers")
	public String updateCustomer(@RequestBody Customer customer) {
		
		customerService.save(customer);
		
		return "Success!";
	}
	
	@DeleteMapping("/customers")
	public String deleteCustomer(@RequestParam(value = "theID") int theID) {
		
		Customer theCustomer = customerService.getById(theID);
		
		if(theCustomer == null) {
			throw new RuntimeException("Customer does not exist!");
		}
		
		customerService.delete(theID);
		
		return "Successfully deleted customer with ID: " + theID;
	}
}
