package com.test.friends.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.friends.entity.FriendFamily;

public interface FriendFamilyRepo extends JpaRepository<FriendFamily, Integer>{
	
	List<FriendFamily> findByPhoneNo(Long phoneNo);

}
