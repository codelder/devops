package com.example.classic;

import com.example.classic.services.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClassicApplication {

	private SettlementService settlementService;

	@Autowired
	public void setSettlementService(SettlementService settlementService){
		this.settlementService = settlementService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ClassicApplication.class, args);
	}

	@GetMapping("/greeting")
	public String greeting() {
		return String.format(settlementService.settle());
	}

}
