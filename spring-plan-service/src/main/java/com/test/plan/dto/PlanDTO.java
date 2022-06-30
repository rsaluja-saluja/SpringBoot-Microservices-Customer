package com.test.plan.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.test.plan.entity.Plan;

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
public class PlanDTO {

	@NotNull(message = "{plan.id.must}")
	Integer planId;
	@NotNull(message = "{plan.name.must}")
	@Length(max = 50,message = "{plan.name.max}")
	String planName;
	@NotNull(message = "{local.rate.must}")
	@Min(value = 5, message = "{local.rate.min}")
	Integer localRate;
	@NotNull(message = "{national.rate.must}")
	@Min(value = 10, message = "{national.rate.min}")
	Integer nationalRate;
	
	//Converts Entity into DTO
	public static PlanDTO valueOf(Plan plan) {
		PlanDTO planDTO= new PlanDTO();
		planDTO.setLocalRate(plan.getLocalRate());
		planDTO.setNationalRate(plan.getNationalRate());
		planDTO.setPlanId(plan.getPlanId());
		planDTO.setPlanName(plan.getPlanName());
		return planDTO;
	}
	
	//Convert DTO into Entity
	public Plan createEntity() {
		Plan plan = new Plan();
		plan.setPlanId(this.getPlanId());
		plan.setPlanName(this.getPlanName());
		plan.setLocalRate(this.getLocalRate());
		plan.setNationalRate(this.getNationalRate());
		return plan;
	}
}
