package com.test.friends.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "friendfamily")
@NoArgsConstructor

@Getter
@Setter
@ToString
public class FriendFamily {

	@Id
	@GeneratedValue
	int id;
	
	@Column(name = "phone_no")
	long phoneNo;

	@Column(name = "friend_and_family")
	long friendAndFamily;

	public FriendFamily(long phoneNo, long friendAndFamily) {
		super();
		this.phoneNo = phoneNo;
		this.friendAndFamily = friendAndFamily;
	}
	
	
}
