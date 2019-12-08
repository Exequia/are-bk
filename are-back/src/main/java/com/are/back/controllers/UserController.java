package com.are.back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.are.back.models.Users;
import com.are.back.services.interfaces.IUsersService;

@RestController
//@GetMapping("/user")
public class UserController {

	@Autowired
	private IUsersService userService;

	@GetMapping("/user/getAll")
	public List<Users> getAll() {
		return userService.getAll();
	}
	
}
