package com.ldd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.ldd")
public class SpringBootMailApplication {
    public static void main(String[] args) {SpringApplication.run(SpringBootMailApplication.class, args);
    }
}
