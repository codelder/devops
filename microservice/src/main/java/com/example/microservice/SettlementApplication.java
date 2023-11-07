package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@RestController
public class SettlementApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SettlementApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
        app.run(args);
    }

    @GetMapping("/settlement")
    public String settlement() {
        return "I'm settlement application";
    }
}
