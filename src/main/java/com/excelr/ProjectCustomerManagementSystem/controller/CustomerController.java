package com.excelr.ProjectCustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.ProjectCustomerManagementSystem.entity.Customer;
import com.excelr.ProjectCustomerManagementSystem.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/greet")
	public String greet(Model model)
	{
		String name="Virat";
		
		Customer customer=new Customer();
		customer.setFirstname("Alice");
		customer.setLastname("Fernandes");
		
		model.addAttribute("player",name);
		model.addAttribute("cust",customer);
		return "welcome";
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
	//Read a record
	@RequestMapping("/getCustomer/{custId}")
	public Customer getCustomer(@PathVariable("custId") int cno)
	{
		return customerService.getCustomer(cno);
	}
	//Read a records
	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers()
	{
			return customerService.getAllCustomers();
	}
	
	@RequestMapping("/newCustomer")
	public String addCustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "add-customer-form";
	}
	//Create/add a record
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer customer)
	{
		customerService.saveCustomer(customer);
		return "Customer-Record-Added";
	}
	
	//Delete a record
	@DeleteMapping("/deleteCustomer/{custId}")
	public String deleteCustomer(@PathVariable("custId") int cno)
	{
		customerService.deleteCustomer(cno);
		return "Customer Deleted";
	}
	
	//Update a record
	@PutMapping("/updateCustomer/{custId}")
	public String updateCustomer(@PathVariable("custId") int cno,@RequestBody Customer customer)
	{
		customerService.updateCustomer(cno,customer);
		return "Customer Updated";
	}
	
	
}
