package com.test.customer.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.util.pattern.PatternParseException.PatternMessage;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.customer.entity.Customer;
import com.test.customer.error.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
public class CustomerDTO {
	
	@NotNull(message = "{phone.no.must}")
	long phoneNo;
	
	@NotNull(message = "{name.must}")
	String name;
	
	@NotNull(message = "{age.must}")
	@Min(value = 16, message = "{age.min}")
	int age;
	
	@NotNull(message = "{gender.must}")
	//@Pattern(regexp = "^[M|F]$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "{gender.value}")
	@Gender(message = "{gender.value}")
	char gender;
	
	List<Long> friendAndFamily;
	
	//@JsonIgnore
	//@NotNull(message = "{password.must}")	
	String password;
	
	@NotNull(message = "{address.must}")
	String address;
	
	PlanDTO currentPlan;
	
	List<CallDetailsDTO> callDetails;
	
	
	public Customer createEntity() {
		Customer customer =  new Customer();
		customer.setPhoneNo(this.getPhoneNo());
		customer.setName(this.getName());
		customer.setAge(this.getAge());
		customer.setGender(this.getGender());
		customer.setPlanId(this.currentPlan.getPlanId());
		customer.setPassword(this.getPassword());
		customer.setAddress(this.getAddress());
		return customer;
		
	}
	
	public static CustomerDTO valueOf(Customer cust) {
		CustomerDTO custDTO = new CustomerDTO();
		custDTO.setPhoneNo(cust.getPhoneNo());
		custDTO.setName(cust.getName());
		custDTO.setAge(cust.getAge());
		custDTO.setGender(cust.getGender());
		custDTO.setPassword(cust.getPassword());
		custDTO.setAddress(cust.getAddress());
		
		PlanDTO planDTO = new PlanDTO();
		planDTO.setPlanId(cust.getPlanId());
		
		custDTO.setCurrentPlan(planDTO);
		
		return custDTO;
	}

	public CustomerDTO(@NotNull(message = "{phone.no.must}") long phoneNo,
			@NotNull(message = "{name.must}") String name,
			@NotNull(message = "{age.must}") @Min(value = 16, message = "{age.min}") int age,
			@NotNull(message = "{gender.must}") char gender, @NotNull(message = "{password.must}") String password,
			@NotNull(message = "{address.must}") String address) {
		super();
		this.phoneNo = phoneNo;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.password = password;
		this.address = address;
	}

	
}
