package com.example.classic;

import com.example.classic.services.SettlementService;
import com.example.classic.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DraftApplication {

	private SettlementService settlementService;
	private LoanService loanService;

	@Autowired
	public void setSettlementService(SettlementService settlementService){
		this.settlementService = settlementService;
	}

	@Autowired
	public void setLoanService(LoanService loanService){
		this.loanService = loanService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DraftApplication.class, args);
	}

	@GetMapping("/draft")
	public String healthy() {
		return String.format(settlementService.settle()+"<br/>"+loanService.loan()+"<br/>I'm draft application");
	}

}
