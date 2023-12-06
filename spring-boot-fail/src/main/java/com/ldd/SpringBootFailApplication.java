package com.ldd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFailApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
//            throw new MyStackException("我的栈异常");
        };
    }

}
