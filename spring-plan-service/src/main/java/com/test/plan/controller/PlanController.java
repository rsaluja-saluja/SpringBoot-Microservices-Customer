package com.test.plan.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.plan.dto.PlanDTO;
import com.test.plan.service.PlanService;

@RestController
@Validated
@PropertySource("classpath:ValidationMessages.properties")
@CrossOrigin
public class PlanController {

	@Autowired
	PlanService planService;
	
	@GetMapping(value = "/plans")
	public List<PlanDTO> getAllPlans() {
		return planService.getAllPlans();
	}
	
	@GetMapping(value = "/plans/{planId}")
	public PlanDTO getSpecificPlanDetails(@Min(value = 1, message = "{plan.id.min}") @PathVariable("planId") int planId) {
		return planService.getSpecificPlan(planId);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/plan")	
	public void createPlan(@Valid @RequestBody PlanDTO planDto) {
		planService.createPlan(planDto);
	}
}
