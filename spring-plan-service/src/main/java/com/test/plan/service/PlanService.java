package com.test.plan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.plan.dto.PlanDTO;
import com.test.plan.entity.Plan;
import com.test.plan.errors.PlanNotFoundException;
import com.test.plan.repository.PlanRepository;

@Service
public class PlanService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PlanRepository planRepo;
	
	public void createPlan(PlanDTO planDto) {
		Plan plan = planDto.createEntity();
		planRepo.save(plan);		
	}
	
	public List<PlanDTO> getAllPlans() {
		List<Plan> plans = planRepo.findAll();
		List<PlanDTO> planDtos = new ArrayList<>();
		
		planDtos =  plans.stream().map(PlanDTO::valueOf).collect(Collectors.toList());
		return planDtos;
	}
	
	public PlanDTO getSpecificPlan(int planId) {
		Optional<Plan> plan = planRepo.findById(planId);
		if(plan.isPresent()) {
			return PlanDTO.valueOf(plan.get());
		} 
		else
			throw new PlanNotFoundException(planId);
	}

}
