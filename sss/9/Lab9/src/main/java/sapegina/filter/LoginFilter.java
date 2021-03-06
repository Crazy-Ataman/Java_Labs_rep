package sapegina.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sapegina.model.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginFilter implements Filter {
    private List<String> avoid_urls;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getServletPath();

        if (!avoid_urls.contains(url)) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendRedirect("login.jsp");
            } else
                filterChain.doFilter(servletRequest, servletResponse); // continue
        } else
            filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("avoid-urls");
        avoid_urls = Arrays.asList(urls.split(","));
    }
}