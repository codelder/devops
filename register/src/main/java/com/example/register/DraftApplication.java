package com.example.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
@RestController
public class DraftApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SettlementApplication.class);
        Properties properties = new Properties();
        properties.setProperty("spring.config.name", "application-draft");

        application.setDefaultProperties(properties);
        application.run(args);
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
