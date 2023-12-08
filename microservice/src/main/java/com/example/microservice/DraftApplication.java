package com.example.microservice;

import com.example.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Import(AppConfig.class)
public class DraftApplication {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DraftApplication.class, args);
    }

    @GetMapping("/draft")
    public String draft() {
        String settle = restTemplate.getForObject("http://localhost:8082/settlement", String.class);
        String loan = restTemplate.getForObject("http://localhost:8083/loan", String.class);
        return settle + "<br/>" + loan + "<br/> I'm draft application";
    }
}
