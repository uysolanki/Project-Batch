package com.excelr.ProjectCustomerManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/getCustomer")
	public Customer getCustomer()
	{
		Customer customer=new Customer();
		customer.setCno(1);
		customer.setEmail("alice@gmail.com");
		customer.setFirstname("Alice");
		customer.setGender("female");
		customer.setLastname("Fernandes");
		customer.setMobileno("9890123123");
		return customer;
	}
	
	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers()
	{
		Customer customer1=new Customer();
		customer1.setCno(1);
		customer1.setEmail("virat@gmail.com");
		customer1.setFirstname("Virat");
		customer1.setGender("male");
		customer1.setLastname("Kohli");
		customer1.setMobileno("9890123333");
		
		Customer customer2=new Customer();
		customer2.setCno(2);
		customer2.setEmail("alice@gmail.com");
		customer2.setFirstname("Alice");
		customer2.setGender("female");
		customer2.setLastname("Fernandes");
		customer2.setMobileno("9890123123");
		
		Customer customer3=new Customer();
		customer3.setCno(3);
		customer3.setEmail("rohit@gmail.com");
		customer3.setFirstname("Rohit");
		customer3.setGender("male");
		customer3.setLastname("Sharma");
		customer3.setMobileno("9890128888");
		
		List<Customer> customers=new ArrayList();
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		return customers;
	}
	
	@RequestMapping("/saveCustomer")
	public String saveCustomer()
	{
		Customer customer=new Customer();
		customer.setEmail("ben@gmail.com");
		customer.setFirstname("Ben");
		customer.setGender("male");
		customer.setLastname("Smith");
		customer.setMobileno("8888123123");
		customerService.saveCustomer(customer);
		return "Customer Record Added";
	}
}
