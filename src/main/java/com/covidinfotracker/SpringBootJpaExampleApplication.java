package com.covidinfotracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootJpaExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaExampleApplication.class, args);
        System.out.println("hello");
    }

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
