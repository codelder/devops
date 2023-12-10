package com.example.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
public class SettlementApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SettlementApplication.class);
        Properties properties = new Properties();
        properties.setProperty("spring.config.name", "application-settlement");

        application.setDefaultProperties(properties);
        application.run(args);
    }

    @RestController
    public static class SettleController {

        private final RestTemplate restTemplate;

        @Autowired
        public SettleController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

        @GetMapping("/settlement")
        public String settle() {
            String accountResponse = restTemplate.getForObject("http://account/account", String.class);
            return accountResponse + "<br/>I'm settlement application";
        }
    }
}
