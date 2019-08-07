package com.demo.crmrestclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.crmrestclient.entity.Customer;
import com.demo.crmrestclient.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/test")
	public String test() {
		return "/test";
	}
	
	@GetMapping("/list")
	public String list(Model theModel) {
		
		List<Customer> customers = customerService.getAll();
		
		theModel.addAttribute("customers", customers);
		
		return "/list-customers";
	}
	
	@GetMapping("/addNewCustomer")
	public String addNewCustomer(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "/customer-form";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerID") int theID, Model theModel) {
		
		Customer theCustomer = customerService.getById(theID);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "/customer-form";
	}
	
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		int theID = theCustomer.getId();
		
		if(theID == 0) {
			customerService.addCustomer(theCustomer);
		}
		else {
			customerService.updateCustomer(theCustomer);
		}
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerID") int theID) {
		
		Customer theCustomer = customerService.getById(theID);
		
		customerService.deleteCustomer(theCustomer);
		
		return "redirect:/customers/list";
	}
	
}
