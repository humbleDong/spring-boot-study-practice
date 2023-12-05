package com.ldd;

import com.ldd.spring.boot.starter.service.TestService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class LddSpringBootStarterSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LddSpringBootStarterSampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TestService testService){
        return (args)->{
            log.info(testService.getServiceName());
        };
    }
}
