package com.are.bets.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bets")
public class BetsController {

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/test")
	public String test(@RequestParam String email) {
		return "test is: " + email;
	}
}
