package com.test.plan.entity;

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
public class Plan {

	@Id
	@Column(name = "plan_id", nullable = false)
	Integer planId;
	
	@Column(name = "plan_name", nullable = false, length = 50)
	String planName;
	
	@Column(name = "local_rate",nullable = false)
	Integer localRate;
	
	@Column(name = "national_rate", nullable = false)
	Integer nationalRate;
	
}
