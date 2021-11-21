package com.are.bets.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetsController {

//	@Autowired
//	private ModelMapper modelMapper;
    @Value("${server.port}")
    private String portNumber;
 
    @Value("${spring.application.name}")
    private String appName;

	@GetMapping("/test")
	public String test(@RequestParam String email) {
		return "Eureza Zuul: " + this.appName  + "(" + this.portNumber +") , getting: " + email;
	}
}
