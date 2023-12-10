package com.example.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Properties;

@SpringBootApplication
@RestController
public class LoanApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(LoanApplication.class);
        Properties properties = new Properties();
        properties.setProperty("spring.config.name", "application-loan");

        application.setDefaultProperties(properties);
        application.run(args);
    }

    @GetMapping("/loan")
    public String loan() {
        return "I'm loan application";
    }
}
