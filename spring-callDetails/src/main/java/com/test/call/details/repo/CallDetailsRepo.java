package com.test.call.details.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.call.details.entity.CallDetails;

public interface CallDetailsRepo extends JpaRepository<CallDetails, Integer>{
	List<CallDetails> findByCalledBy(Long phoneNo);

}
