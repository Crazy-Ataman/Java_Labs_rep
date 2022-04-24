package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "TimeServlet", value = "/TimeServlet")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String time = "Current time is " + LocalTime.now().toString().substring(0, 8);

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<h1>" + time + "</h1>");
        writer.println(getRequestInfo(request, response));
        // The same as above
        response.getWriter().println("<h2>" + "Information from header:" + "</h2>");
        response.getWriter().println(getHeaderInfo(request));
    }

    private String getRequestInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String result = "";
        result += "<p>" + "Access method: " + request.getMethod() + "</p>";
        result += "<p>" + "URL: " + request.getRequestURL() + "</p>";
        result += "<p>" + "Protocol: " + request.getProtocol() + "</p>";
        result += "<p>" + "The request came from IP-address: " + request.getRemoteAddr() + "</p>";
        result += "<p>" + "Host: " + request.getRemoteHost() + "</p>";
        result += "<p>" + "Username: " + request.getRemoteUser() + "</p>";
        result += "<p>" + "Port number: " + request.getRemotePort() + "</p>";
        result += "<p>" + "HTTP request string: " + request.getQueryString() + "</p>";
        result += "<p>" + "Server name: " + request.getServerName() + "</p>";
        result += "<p>" + "Port: " + request.getServerPort() + "</p>";
        result += "<p>" + "Path: " + request.getContextPath() + "</p>";
        result += "<p>" + "Scheme: " + request.getScheme() + "</p>";
        return result;
    }

    private String getHeaderInfo(HttpServletRequest request) throws IOException {
        String result = "";
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            result += "<p>" + name + " = " + value + "</p>";
        }
        return result;
    }

    public void destroy() {
    }
}
