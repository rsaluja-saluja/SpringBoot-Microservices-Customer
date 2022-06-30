package com.test.call.details.dto;

import java.time.LocalDate;

import com.test.call.details.entity.CallDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CallDetailsDTO {

	long calledBy;

	long calledTo;

	LocalDate calledOn;

	int duration;

	// Converts Entity into DTO
	public static CallDetailsDTO valueOf(CallDetails callDetails) {
		CallDetailsDTO callsDTO = new CallDetailsDTO();
		callsDTO.setCalledBy(callDetails.getCalledBy());
		callsDTO.setCalledOn(callDetails.getCalledOn());
		callsDTO.setCalledTo(callDetails.getCalledTo());
		callsDTO.setDuration(callDetails.getDuration());
		return callsDTO;
	}
}
