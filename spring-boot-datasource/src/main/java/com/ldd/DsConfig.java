package com.ldd;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author ldd
 * @Date 2023/12/8
 */
@Configuration
public class DsConfig {

/*    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.xxx.one")
    public DataSource dataSource1() {
        return new XxxDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.xxx.two")
    public DataSource dataSource2() {
        return new XxxDataSource();
    }*/

}