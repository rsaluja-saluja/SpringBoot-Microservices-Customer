package com.test.plan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.plan.entity.Plan;
import com.test.plan.repository.PlanRepository;

@SpringBootApplication
public class SpringPlanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlanServiceApplication.class, args);
	}

	 @Bean
	    CommandLineRunner initDatabase(PlanRepository repository) {
	        return args -> {
	        	repository.save(new Plan(1,"Plan 1",10,20));
	        	repository.save(new Plan(2,"Plan 2",15,25));
	        	repository.save(new Plan(3,"Plan 3",12,15));
	        	repository.save(new Plan(4,"Plan 4",7,15));
	        };
	    }
}
