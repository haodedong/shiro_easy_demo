package com.hdd.shiro_demo.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Component
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
      /*  HttpServletRequest request = (HttpServletRequest) srequest;
        HttpServletResponse response = (HttpServletResponse) sresponse*/
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
