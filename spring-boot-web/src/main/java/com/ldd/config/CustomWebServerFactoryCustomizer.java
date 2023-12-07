package com.ldd.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * @Author ldd
 * @Date 2023/12/7
 * 通过java的方式修改Servlet的配置
 */
public class CustomWebServerFactoryCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {


    @Override
    public void customize(ConfigurableWebServerFactory server) {
        server.setPort(8081);
    }
}
