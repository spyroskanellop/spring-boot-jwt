package com.example.userservicewebtoken;

import com.example.userservicewebtoken.entity.Role;
import com.example.userservicewebtoken.entity.User;
import com.example.userservicewebtoken.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceWebtokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceWebtokenApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserService userService){
		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new User(null, "spyros kan", "skan", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "spyros kan1", "skan1", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "spyros kan2", "skan2", "1234", new ArrayList<>()));
//			userService.saveUser(new User(null, "spyros kan3", "john", "1234", new ArrayList<>()));


			userService.addRoleToUser("skan", "ROLE_MANAGER");
			userService.addRoleToUser("skan1", "ROLE_USER");
			userService.addRoleToUser("skan2", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("john", "ROLE_ADMIN");

		};
	}
}
