package com.test.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.test.customer.entity.Customer;
import com.test.customer.repo.CustomerRepository;

@SpringBootApplication
public class SpringCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCustomerServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplae() {
		return new RestTemplate();
	}
	
	@Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {
        return args -> {
        	repository.save(new Customer(Long.valueOf(9911234l),"Customer 1",20,"street 1","customer1",'F',1));
        	repository.save(new Customer(Long.valueOf(9911235l),"Customer 2",20,"street 2","customer2",'M',3));
        };
	}
}
