package com.study.hexagonal.architecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SampleHexArchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleHexArchApplication.class, args);
    }
}
