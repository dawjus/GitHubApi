package com.example.recruitment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RecruitmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitmentApplication.class, args);
    }

}
