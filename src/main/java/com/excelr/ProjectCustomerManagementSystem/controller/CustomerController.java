package com.excelr.ProjectCustomerManagementSystem.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	//@RequestMapping("/getAllCustomers")
	@RequestMapping(value={"/getAllCustomers","/homepage","/project"})
	public String getAllCustomers(Model model)
	{
		List<Customer> customers=customerService.getAllCustomers();
		model.addAttribute("customers",customers);
		return "show-customer-list";
	}
	
	//new customer form
	@RequestMapping("/newCustomer")
	public String addCustomer(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
		return "add-customer-form";
	}
	
	//save details about customer
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute Customer customer)
	{
		customerService.saveCustomer(customer);
		return "redirect:/getAllCustomers";
	}
	
	//Delete a customer
	@RequestMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") int cno)
	{
		customerService.deleteCustomer(cno);
		return "redirect:/getAllCustomers";
	}
	
	//update customer form
	@RequestMapping("/updatecustomerform/{id}")
	public String updatecustomerform(@PathVariable("id") int cno, Model model)
	{
		Customer customer=customerService.getCustomer(cno);
		model.addAttribute("customer",customer);
		return "update-customer-form";
	}
	
	//Update a customer
	@PostMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable("id") int cno,@ModelAttribute Customer customer)
	{
		customerService.updateCustomer(cno,customer);
		return "redirect:/getAllCustomers";
	}
	
	@RequestMapping("/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
