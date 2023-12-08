package com.ldd.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ldd.handler.CustomConverter;
import com.ldd.handler.StringWithoutSpaceDeserializer;
import com.ldd.interceptor.LoginInterceptor;
import com.ldd.servlet.RegisterServlet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @Author ldd
 * @Date 2023/12/7
 * web的配置中心
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
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

    /**
     * Locale 默认设置为英文
     * @return LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * 切换语言拦截器，通过url?lang=zh_CN形式进行切换
     * @return
     */
    private LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }


    /**
     * 全局跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**")
                .allowedMethods("GET", "POST")
                .allowedOrigins("https://gh.qisui.xyz")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(true).maxAge(3600);
    }

}

