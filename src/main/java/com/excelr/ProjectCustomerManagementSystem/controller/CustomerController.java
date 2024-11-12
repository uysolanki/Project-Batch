package com.excelr.ProjectCustomerManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ProjectCustomerManagementSystem.entity.Customer;
import com.excelr.ProjectCustomerManagementSystem.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/greet")
	public String greet()
	{
		return "Welcome to Training Session";
	}
	
	@RequestMapping("/cricket")
	public String cricket()
	{
		return "Virat Kohli";
	}
	
	@RequestMapping("/dhoni")
	public String dhoni()
	{
		return "Welcome to Chennai super Kings";
	}
	
	@RequestMapping("/getCustomer/{custId}")
	public Customer getCustomer(@PathVariable("custId") int cno)
	{
		return customerService.getCustomer(cno);
	}
	
	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers()
	{
			return customerService.getAllCustomers();
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer()
	{
		Customer customer=new Customer();
		customer.setEmail("alice@gmail.com");
		customer.setFirstname("Alice");
		customer.setGender("female");
		customer.setLastname("Fernandes");
		customer.setMobileno("9890123123");
		customerService.saveCustomer(customer);
		return "Customer Record Added";
	}
	
	@RequestMapping("/deleteCustomer/{custId}")
	public String deleteCustomer(@PathVariable("custId") int cno)
	{
		customerService.deleteCustomer(cno);
		return "Customer Deleted";
	}
}
