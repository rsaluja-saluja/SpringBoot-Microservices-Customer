package com.test.customer.error;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message) {
		super(message);
	}

//	public CustomerNotFoundException(Long phoneNo) {
//		super("Customer not found with phone no "+phoneNo);
//	}
}
