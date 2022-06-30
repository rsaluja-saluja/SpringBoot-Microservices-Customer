package com.test.friends.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.friends.dto.FriendFamilyDTO;
import com.test.friends.dto.FriendListDTO;
import com.test.friends.service.FriendFamilyService;

@RestController
@CrossOrigin
public class FriendFamilyController {

	@Autowired
	FriendFamilyService friendService;
	
	@PostMapping(value = "/customers/{phoneNo}/friends")
	public void saveFriend(@PathVariable("phoneNo") Long phoneNo, @RequestBody FriendFamilyDTO friendDTO) {
		friendService.saveFriend(phoneNo, friendDTO);
	}
	
	@GetMapping(value = "/customers/{phoneNo}/friends")
	public FriendListDTO getSpecificFriends(@PathVariable("phoneNo") Long phoneNo){
		return friendService.getSpecificFriends(phoneNo);
	}
}
