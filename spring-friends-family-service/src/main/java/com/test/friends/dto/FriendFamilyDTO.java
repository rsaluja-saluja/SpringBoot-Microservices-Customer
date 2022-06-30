package com.test.friends.dto;

import com.test.friends.entity.FriendFamily;

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
public class FriendFamilyDTO {

	long phoneNo;
	long friendAndFamily;

	// Converts DTO into Entity
	public FriendFamily createFriend() {
		FriendFamily friend = new FriendFamily();
		friend.setPhoneNo(this.getPhoneNo());
		friend.setFriendAndFamily(this.getFriendAndFamily());
		return friend;
	}
}
