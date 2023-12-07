package com.ldd.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Author ldd
 * @Date 2023/12/7
 */
@WebFilter(filterName = "javaFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "name", value = "javaServlet"),
                @WebInitParam(name = "code", value = "1234")
        }
)
@Slf4j
public class JavaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("javaFilter init");
        String name = filterConfig.getInitParameter("name");
        String code = filterConfig.getInitParameter("code");
        log.info("name：" + name);
        log.info("code：" + code);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("java filter processing");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("java filter destroy");
    }
}
