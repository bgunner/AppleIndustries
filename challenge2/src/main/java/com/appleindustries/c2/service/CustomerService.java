package com.appleindustries.c2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appleindustries.c2.model.Customer;
import com.appleindustries.c2.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;	
	
	protected Customer getCustomer(Long id) {
		
		Optional<Customer> optCust = customerRepository.findById(id);
		return optCust.orElseThrow();
		
	}

}
