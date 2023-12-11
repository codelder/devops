package org.example.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SettlementApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SettlementApplication.class, args);
    }

    @RestController
    public static class SettleController {

        private final RestTemplate restTemplate;

        @Autowired
        public SettleController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @GetMapping("/settlement")
        public String settle() {
            String accountResponse = restTemplate.getForObject("http://localhost:8081/account", String.class);
            return accountResponse + "<br/>I'm settlement application";
        }
    }
}
