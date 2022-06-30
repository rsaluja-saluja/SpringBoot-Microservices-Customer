package com.test.customer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.test.customer.dto.CustomerDTO;
import com.test.customer.dto.LoginDTO;
import com.test.customer.entity.Customer;
import com.test.customer.error.CustomerNotFoundException;
import com.test.customer.repo.CustomerRepository;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class CustomerService {

	@Autowired
	CustomerRepository custRepo;
	
	@Autowired
	Environment env;
	
	public CustomerDTO createCustomer(CustomerDTO custDTO) {
		Customer cust = custDTO.createEntity();
		return CustomerDTO.valueOf(custRepo.save(cust));
	}
	
	public boolean login(LoginDTO loginDTO) {
		Optional<Customer> cust = custRepo.findById(loginDTO.getPhoneNo());
		
		if(cust.isPresent()) {
			if(cust.get().getPassword().equals(loginDTO.getPassword()))
				return true;
			else
				return false;
		}
		throw new CustomerNotFoundException(env.getProperty("customer.not.found")+loginDTO.getPhoneNo());	
	}
	
	public CustomerDTO getCustomerProfile(Long phoneNo) {
		Optional<Customer> cust = custRepo.findById(phoneNo);
		
		if(cust.isPresent()) {
			return CustomerDTO.valueOf(cust.get());
		}
		throw new CustomerNotFoundException(env.getProperty("customer.not.found")+phoneNo);
	}

	public List<CustomerDTO> getCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = custRepo.findAll();
		List<CustomerDTO> customerDTOs = customers.stream().map(CustomerDTO::valueOf).collect(Collectors.toList());
		return customerDTOs;
	}
}
