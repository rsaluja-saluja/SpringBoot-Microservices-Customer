package com.test.call.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.call.details.dto.CallDetailsDTO;
import com.test.call.details.dto.CallDetailsListDTO;
import com.test.call.details.service.CallDetailsService;

@RestController
public class CallDetailsController {

	@Autowired
	CallDetailsService callDetailsService;
	
	@GetMapping(value = "/customers/{phoneNo}/callDetails")
	public CallDetailsListDTO getCustomerCallDetails(@PathVariable("phoneNo") Long phoneNo) {
		return callDetailsService.getCustomerCallDetails(phoneNo);
	}
}
