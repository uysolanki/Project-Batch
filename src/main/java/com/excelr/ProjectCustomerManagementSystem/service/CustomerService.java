package com.excelr.ProjectCustomerManagementSystem.service;

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

}
