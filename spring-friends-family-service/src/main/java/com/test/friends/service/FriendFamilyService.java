package com.test.friends.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.friends.dto.FriendFamilyDTO;
import com.test.friends.dto.FriendListDTO;
import com.test.friends.entity.FriendFamily;
import com.test.friends.repository.FriendFamilyRepo;

@Service
public class FriendFamilyService {

	@Autowired
	FriendFamilyRepo friendRepo;
	
	public void saveFriend(Long phoneNo, FriendFamilyDTO friendDTO) {
		friendDTO.setPhoneNo(phoneNo);
		FriendFamily friend = friendDTO.createFriend();
		friendRepo.save(friend);
	}
	
	public FriendListDTO getSpecificFriends(Long phoneNo) {
		List<FriendFamily> friends = friendRepo.findByPhoneNo(phoneNo);
		List<Long> friendList = new ArrayList<>();
		friendList = friends.stream().map(FriendFamily::getFriendAndFamily).collect(Collectors.toList());
		return new FriendListDTO(friendList);
	}
}
