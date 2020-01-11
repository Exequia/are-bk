package com.are.bets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AreBetsApplication {
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

	public static void main(String[] args) {
		SpringApplication.run(AreBetsApplication.class, args);
	}

}
