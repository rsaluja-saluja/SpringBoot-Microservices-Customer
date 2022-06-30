package com.test.friends;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.friends.entity.FriendFamily;
import com.test.friends.repository.FriendFamilyRepo;

@SpringBootApplication
public class SpringFriendsFamilyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFriendsFamilyServiceApplication.class, args);
	}

	@Bean
    CommandLineRunner initDatabase(FriendFamilyRepo repository) {
        return args -> {
        	repository.save(new FriendFamily(9911234,9911789));
        	repository.save(new FriendFamily(9911234,9911788));
        	repository.save(new FriendFamily(9911234,9911787));
        	repository.save(new FriendFamily(9911235,9911777));
        	repository.save(new FriendFamily(9911235,9911778));
        	
        };
    }
}
