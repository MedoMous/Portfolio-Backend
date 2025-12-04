package com.med.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/api/v1/software-engineers")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
