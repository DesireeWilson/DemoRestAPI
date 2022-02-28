package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(UserService userService) {
//		List<User> users = new ArrayList<>();
//
//		User ruslan = new User();
//		ruslan.setId(1L);
//		ruslan.setFirstName("Ruslan");
//		ruslan.setLastName("Zinovyev");
//		ruslan.setAge(37);
//		ruslan.setEmailAddress("ruslan.zinovyev@gmail.com");
//
//		User desiree = new User();
//		desiree.setId(2L);
//		desiree.setFirstName("Desiree");
//		desiree.setLastName("Wilson");
//		desiree.setAge(19);
//		desiree.setEmailAddress("desiree.wilson@gmail.com");
//
//		User john = new User();
//		john.setId(3L);
//		john.setFirstName("John");
//		john.setLastName("Doe");
//		john.setAge(30);
//		john.setEmailAddress("john.doe@gmail.com");
//
//		users.add(ruslan);
//		users.add(desiree);
//		users.add(john);
//
//		return args -> users.forEach(userService::save);
//
//	}

}
