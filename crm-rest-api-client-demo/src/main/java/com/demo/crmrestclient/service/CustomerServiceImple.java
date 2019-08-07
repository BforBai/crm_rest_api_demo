package com.demo.crmrestclient.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import com.demo.crmrestclient.entity.Customer;

@Service
public class CustomerServiceImple implements CustomerService {

	private RestTemplate restTemplate;
	
	private String crmRestApiUrl;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CustomerServiceImple(RestTemplate theRestTemplate, @Value("${crm.rest.api.url}") String ApiUrl) {
		
		restTemplate = theRestTemplate;
		crmRestApiUrl = ApiUrl;
		
		logger.info("Rest API URL is: " + crmRestApiUrl);
		
	}

	@Override
	public List<Customer> getAll() {
		
		logger.info("Calling GET API");
		
		//use ParameterizedTypeReference to get the list of customers
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmRestApiUrl, 
														HttpMethod.GET, null, 
														new ParameterizedTypeReference<List<Customer>>() {});
		List<Customer> customers = responseEntity.getBody();
		
		return customers;
	}

	@Override
	public Customer getById(int theID) {
		
		logger.info("Calling GET API with customer ID");
		
		Customer theCustomer = restTemplate.getForObject(crmRestApiUrl + "/" + theID, Customer.class);
		
		return theCustomer;
	}
	
	@Override
	public void addCustomer(Customer theCustomer) {
		
		logger.info("Calling POST API");
		
		restTemplate.postForObject(crmRestApiUrl, theCustomer, String.class);
		
		logger.info("Customer added!");
		
	}

	@Override
	public void updateCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		logger.info("Calling PUT API");
		
		restTemplate.put(crmRestApiUrl, theCustomer);
		
		logger.info("Updated successfully!");
		
	}

	@Override
	public void deleteCustomer(Customer theCustomer) {
		
		logger.info("Calling DELETE API");

		restTemplate.delete(crmRestApiUrl + "?theID=" + theCustomer.getId());
		
		logger.info("Customer deleted!");
	}

}
