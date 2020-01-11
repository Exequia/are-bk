package com.are.users.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.are.users.dtos.UserResponseDTO;
import com.are.users.models.User;
import com.are.users.services.interfaces.IUsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	private IUsersService userService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestParam String email, @RequestParam String password) {
		return "I got it";
	}
	
	@GetMapping("/getByEmail")
	public UserResponseDTO getByEmail(@RequestParam String email) {
		User user =  userService.findByEmail(email);
		UserResponseDTO userDto = modelMapper.map(user, UserResponseDTO.class);
		return userDto;
	}
}
