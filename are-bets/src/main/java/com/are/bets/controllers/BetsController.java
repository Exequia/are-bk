package com.are.bets.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

@RestController
@RequestMapping("/api/bets")
public class BetsController {

//	@Autowired
//	private ModelMapper modelMapper;
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;
 
    @Value("${spring.application.name}")
    private String appName;

	@GetMapping("/test")
	public String test(@RequestParam String email) {
		return "testing: " + this.appName  + ", getting: " + email;
	}
}
