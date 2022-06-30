package com.test.call.details.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "calldetails")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CallDetails {

	@Id
	@GeneratedValue
	long id;
	
	@Column(nullable = false)
	long calledBy;
	
	@Column(nullable = false)
	long calledTo;
	
	@Column(nullable = false)
	LocalDate calledOn;
	
	@Column(nullable = false)
	int duration;
	
	public CallDetails(long calledBy, long calledTo, LocalDate calledOn, int duration) {
		super();
		this.calledBy = calledBy;
		this.calledTo = calledTo;
		this.calledOn = calledOn;
		this.duration = duration;
	}
		
}
