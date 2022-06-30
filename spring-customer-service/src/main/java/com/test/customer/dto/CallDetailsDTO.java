package com.test.customer.dto;

import java.time.LocalDate;

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

	
}
