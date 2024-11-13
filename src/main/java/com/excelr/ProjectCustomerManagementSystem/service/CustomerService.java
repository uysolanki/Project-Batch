package com.excelr.ProjectCustomerManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ProjectCustomerManagementSystem.entity.Customer;
import com.excelr.ProjectCustomerManagementSystem.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	public void deleteCustomer(int cno) {
		customerRepository.deleteById(cno);	
	}
	public Customer getCustomer(int cno) {
		return customerRepository.findById(cno).get();
		
	}
	public void updateCustomer(int cno, Customer customer) {
		Customer customerDb=customerRepository.findById(cno).get();
		customerDb.setEmail(customer.getEmail());
		customerDb.setFirstname(customer.getFirstname());
		customerDb.setLastname(customer.getLastname());
		customerDb.setMobileno(customer.getMobileno());
		customerRepository.save(customerDb);
		
	}

}
