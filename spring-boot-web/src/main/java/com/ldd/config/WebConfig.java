package com.ldd.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ldd.handler.CustomConverter;
import com.ldd.handler.StringWithoutSpaceDeserializer;
import com.ldd.interceptor.LoginInterceptor;
import com.ldd.servlet.RegisterServlet;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author ldd
 * @Date 2023/12/7
 * web的配置中心
 */
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;

    /**
     * 一个简单的登录拦截器
     * @param registry 拦截器注册
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login/**")
//                .excludePathPatterns("/static/**");
//    }


    /**
     * 自定义了一个消息转换器，作用：设置了反序列化过程中遇到不明确的参数时不用失败，并且配置了一个字符串的反序列化器，用来过滤HTTP请求字符串参数首尾的空格
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new StringWithoutSpaceDeserializer(String.class));
        mapper.registerModule(module);

        converter.setObjectMapper(mapper);
        return converter;
    }

    /**
     * 尝试注册Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean registerServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new RegisterServlet(), "/registerServlet");
        servletRegistrationBean.addInitParameter("name", "registerServlet");
        servletRegistrationBean.addInitParameter("sex", "boy");
        servletRegistrationBean.setIgnoreRegistrationFailure(true);
        return servletRegistrationBean;
    }

    /**
     * 这是一个类型转换器，作用就是去掉请求参数中的首位空格
     * @param registry 注册器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CustomConverter());
    }

    /**
     * 而外添加classpath下静态目录的映射   assets和dist
     * @param registry ResourceHandlerRegistry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/dist/");

    }
}

