package com.are.back;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.are.back.models.Users;
import com.are.back.repositories.IUsersRepo;

@SpringBootTest
class UsersTests {
	
	@Autowired
	private IUsersRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void createNewUser() {
		Users user = new Users();
		user.setId(0);
		user.setAlias("Fénix");
		user.setEmail("real.estepa@gmail.com");
		user.setPassword(encoder.encode("FnxPa$$"));
		Users response = userRepo.save(user);

		assertTrue(response.getAlias().equalsIgnoreCase(user.getAlias()));
		assertTrue(response.getEmail().equalsIgnoreCase(user.getEmail()));
		assertTrue(response.getPassword().equalsIgnoreCase(user.getPassword()));
	}
}
