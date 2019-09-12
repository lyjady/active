package com.example.activespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActiveSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveSpringBootApplication.class, args);
    }

}
