package org.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@SpringBootApplication
@RestController
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AccountApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.run(args);
    }

    @GetMapping("/account")
    public String account() {
        return "I'm account application";
    }
}
