package com.example.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DraftApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DraftApplication.class, args);
    }

    @RestController
    public static class DraftController {

        private final RestTemplate restTemplate;

        @Autowired
        public DraftController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}
        @GetMapping("/draft")
        public String draft() {
            String settle = restTemplate.getForObject("http://localhost:8082/settlement", String.class);
            String loan = restTemplate.getForObject("http://localhost:8083/loan", String.class);
            return settle + "<br/>" + loan + "<br/> I'm draft application";
        }
    }
}
