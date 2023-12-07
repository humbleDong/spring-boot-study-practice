package com.ldd.config;

import com.ldd.servlet.InitServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

/**
 * @Author ldd
 * @Date 2023/12/7
 * 扫描组件的注册方式
 */
@Component
public class ServletConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic initServlet = servletContext.addServlet("initServlet", InitServlet.class);
        initServlet.addMapping("/initServlet");
        initServlet.setInitParameter("name","initServlet");
        initServlet.setInitParameter("sex","none");
    }
}
