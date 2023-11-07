package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(DraftApplication.class, args);
	}

	@GetMapping("/draft")
	public String draft() {
		return "I'm draft application";
	}
}
