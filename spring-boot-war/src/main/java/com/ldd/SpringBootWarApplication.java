package com.ldd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWarApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWarApplication.class);
    }

    public static void main(String[] args) {
        startBuilder(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder startBuilder(SpringApplicationBuilder builder){
        return builder.sources(SpringBootWarApplication.class);
    }

}
