package com.test.plan.errors;

public class PlanNotFoundException extends RuntimeException {
	
	public PlanNotFoundException(int planId) {
		super("Plan no found with id: "+planId);
	}
}
;