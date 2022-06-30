package com.test.call.details.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.call.details.dto.CallDetailsDTO;
import com.test.call.details.dto.CallDetailsListDTO;
import com.test.call.details.entity.CallDetails;
import com.test.call.details.repo.CallDetailsRepo;

@Service
public class CallDetailsService {

	@Autowired
	CallDetailsRepo callDetailsRepo;
	
	public CallDetailsListDTO getCustomerCallDetails(Long phoneNo) {
		List<CallDetails> callDetails = callDetailsRepo.findByCalledBy(phoneNo);
		List<CallDetailsDTO> callDetailsDTO = new ArrayList<>();
		callDetailsDTO = callDetails.stream().map(CallDetailsDTO::valueOf).collect(Collectors.toList());
		return new CallDetailsListDTO(callDetailsDTO);
	}
}
