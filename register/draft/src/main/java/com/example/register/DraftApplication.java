package com.example.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DraftApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DraftApplication.class,args);
    }

    @RestController
    public static class DraftController {

        private final RestTemplate restTemplate;

        @Autowired
        public DraftController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

        @GetMapping("/draft")
        public String draft() {
            String settle = restTemplate.getForObject("http://settlement/settlement", String.class);
            String loan = restTemplate.getForObject("http://loan/loan", String.class);
            return settle + "<br/>" + loan + "<br/> I'm draft application";
        }
    }
}
