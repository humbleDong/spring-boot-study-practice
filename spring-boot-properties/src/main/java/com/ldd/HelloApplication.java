package com.ldd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);

        SpringApplication springApplication = new SpringApplication(HelloApplication.class);
        springApplication.run(args);
    }

}
