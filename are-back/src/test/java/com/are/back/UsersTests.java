package com.are.back;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.are.back.models.Role;
import com.are.back.models.User;
import com.are.back.repositories.IUsersRepo;

@SpringBootTest
class UsersTests {
	
	@Autowired
	private IUsersRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void createNewUser() {
		User user = new User();
		user.setUsername("fnx");
		user.setEmail("aa@aa.aa");
		user.setPassword(encoder.encode("pass"));
		
		Role role = new Role();
		role.setId(2);
		
		User response = userRepo.save(user);

		assertTrue(response.getUsername().equalsIgnoreCase(user.getUsername()));
		assertTrue(response.getEmail().equalsIgnoreCase(user.getEmail()));
		assertTrue(response.getPassword().equalsIgnoreCase(user.getPassword()));
		assertTrue(response.getRole().getId() == (user.getRole().getId()));
	}
}
