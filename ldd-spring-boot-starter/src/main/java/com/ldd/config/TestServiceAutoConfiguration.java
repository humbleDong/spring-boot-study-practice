package com.ldd.config;

import com.ldd.service.TestService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @Author ldd
 * @Date 2023/12/5
 */
@AutoConfiguration
@ConditionalOnProperty(prefix = "ldd.starter",name = "enabled",havingValue = "true")
public class TestServiceAutoConfiguration {

    @Bean
    public TestService testService(){
        return new TestService();
    }
}
