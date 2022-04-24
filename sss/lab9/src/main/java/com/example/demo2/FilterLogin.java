package com.example.demo2;

import com.example.demo2.DB.DB;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class FilterLogin implements Filter {
    private List<String> avoidUrls;

    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        String urls = config.getInitParameter("avoid-pages");
        avoidUrls = Arrays.asList(urls.split(","));
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String url = httpServletRequest.getServletPath();

        if(!avoidUrls.contains(url)){
            System.out.println("url: " + url);
            HttpSession session = httpServletRequest.getSession();
            String Login = (String) session.getAttribute("username");
            if(Login == null){
                httpServletResponse.sendRedirect("registerForm.jsp");
            }else{
                chain.doFilter(request, response);
            }
        }
        else
            chain.doFilter(request, response);
    }
}
