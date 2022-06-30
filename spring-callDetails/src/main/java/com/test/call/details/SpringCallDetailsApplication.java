package com.test.call.details;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.call.details.entity.CallDetails;
import com.test.call.details.repo.CallDetailsRepo;

@SpringBootApplication
public class SpringCallDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCallDetailsApplication.class, args);
	}

	@Bean
    CommandLineRunner initDatabase(CallDetailsRepo repository) {
        return args -> {
        	repository.save(new CallDetails(9911234, 9911789, LocalDate.parse("2022-06-23"), 65));
        	repository.save(new CallDetails(9911234, 9911790, LocalDate.parse("2022-06-23"), 10));
        	repository.save(new CallDetails(9911234, 9911791, LocalDate.parse("2022-04-25"), 15));
        	repository.save(new CallDetails(9911235, 9911777, LocalDate.parse("2022-06-20"), 80));
        	repository.save(new CallDetails(9911235, 9911778, LocalDate.parse("2022-06-21"), 90));
        	repository.save(new CallDetails(9911235, 9911777, LocalDate.parse("2022-04-22"), 30));

        };
        
	}
}
