package com.github.akhuntsaria.protectedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProtectedServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtectedServiceApplication.class, args);
    }

}
