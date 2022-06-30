package com.test.customer.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.customer.dto.CustomerDTO;
import com.test.customer.service.CustomerService;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private CustomerService custService;
	
	
	@Test	
	void testCreateCustomerValid() throws Exception {
		CustomerDTO customerDTO = new CustomerDTO(991124,"CustomerName",18,'F',"customer","street1");
		
		Mockito.when(custService.createCustomer(Mockito.any(CustomerDTO.class)))
				.thenReturn(customerDTO);
		mockmvc.perform(post("/customers")
				.content(new ObjectMapper().writeValueAsString(customerDTO))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.phoneNo", is(991124)))
			.andExpect(jsonPath("$.name", is("CustomerName")))
			.andExpect(jsonPath("$.age", is(18)))
			.andDo(print());
		
		//Mockito.verify(custService).createCustomer(customerDTO);
	}

}
