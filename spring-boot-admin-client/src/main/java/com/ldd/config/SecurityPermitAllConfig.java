package com.ldd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @Author ldd
 * @Date 2023/12/14
 */
@Configuration
public class SecurityPermitAllConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((authorize) -> {
            authorize.anyRequest().permitAll();
        }).csrf().disable().build();
    }
}
