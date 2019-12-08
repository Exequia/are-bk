package com.are.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.are.back.models.Users;
import com.are.back.repositories.IUserRepo;

@RestController
public class UserController {

	@Autowired
	private IUserRepo userRepo;

	@GetMapping("/user/testSave")
	  public String testSave() {
		Users user = new Users();
		user.setName("Fenix");
		user.setPassword("fnx");
		this.userRepo.save(user);
	    return "index";
	  }
}
