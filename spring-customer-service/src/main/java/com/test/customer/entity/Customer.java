package com.test.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

	@Id
	@Column(name = "phone_no", nullable = false)
	Long phoneNo;
	
	@Column(nullable = false, length = 50)
	String name;
	
	@Column(nullable = false)
	Integer age;
	
	@Column(nullable = false, length = 50)
	String address;
	
	@Column(nullable = false, length = 50)
	String password;
	
	@Column(nullable = false, length = 1)
	char gender;
	
	@Column(name="plan_id",nullable = false)
	Integer planId;
	
}
