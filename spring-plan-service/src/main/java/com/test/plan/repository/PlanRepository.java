package com.test.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.plan.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{

}
