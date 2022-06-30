package com.test.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.customer.dto.CallDetailsListDTO;
import com.test.customer.dto.CustomerDTO;
import com.test.customer.dto.FriendListDTO;
import com.test.customer.dto.LoginDTO;
import com.test.customer.dto.PlanDTO;
import com.test.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	CustomerService custService;
	
	@Value("${friend.uri}")
	String friendUri;

	@Value("${plan.uri}")
	String planUri;
	
	@Value("${callDetails.uri}")
	String callDetailsUri;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value = "/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO custDTO) {
		return custService.createCustomer(custDTO);
	}
	
	@PostMapping(value = "/login")
	public boolean login(@RequestBody LoginDTO loginDTO) {
		return custService.login(loginDTO);
	}
	
	@GetMapping(value = "/customers")
	public List<CustomerDTO> getCustomers(){
		return custService.getCustomers();
	}
	
	@GetMapping(value = "/customers/{phoneNo}", produces = "application/json")
	public CustomerDTO getCustomerProfile(@PathVariable("phoneNo") Long phoneNo) {
		CustomerDTO custDTO = custService.getCustomerProfile(phoneNo);

		PlanDTO planDTO = restTemplate.getForObject(planUri+custDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		custDTO.setCurrentPlan(planDTO);
	
//		@SuppressWarnings("unchecked")
		FriendListDTO friendListDTO = restTemplate.getForObject(friendUri+phoneNo+"/friends", FriendListDTO.class);
		custDTO.setFriendAndFamily(friendListDTO.getFriends());
		
		CallDetailsListDTO callDetails = restTemplate.getForObject(callDetailsUri+phoneNo+"/callDetails", CallDetailsListDTO.class);
		custDTO.setCallDetails(callDetails.getCallDetails());
		
		return custDTO;
	}
	
	
}
