package com.ldd.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author ldd
 * @Date 2023/12/7
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String userSession = (String) session.getAttribute("userSession");

        if (userSession == null) {
            response.sendRedirect("/login");
            return false;
        } else {
            return true;
        }
    }
}
