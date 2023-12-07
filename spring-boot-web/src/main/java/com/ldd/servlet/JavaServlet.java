package com.ldd.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author ldd
 * @Date 2023/12/7
 */


@WebServlet(name = "javaServlet", urlPatterns = "/javaServlet", asyncSupported = true,
        initParams = {
                @WebInitParam(name = "name", value = "javaServlet"),
                @WebInitParam(name = "sex", value = "girl")
        })
public class JavaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = getServletConfig().getInitParameter("name");
        String sex = getServletConfig().getInitParameter("sex");

        resp.getOutputStream().println("name: " + name);
        resp.getOutputStream().println("sex: " + sex);
    }
}
