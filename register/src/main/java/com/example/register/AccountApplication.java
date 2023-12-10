package com.example.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AccountApplication.class);
        Properties properties = new Properties();
        properties.setProperty("spring.config.name", "application-account");

        application.setDefaultProperties(properties);
        application.run(args);
    }

    @GetMapping("/account")
    public String account() {
        return "I'm account application";
    }
}
