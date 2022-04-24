package sapegina.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Enumeration;

public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html><h1>");
        pw.println(LocalTime.now().toString().substring(0, 8));
        pw.println("</h1>");
        pw.println("<p>Версия и номер протокола " + "<b>" + request.getProtocol() + "</b>" + "</p>");
        pw.println("<p>IP-адреса клиента, от имени которого пришел запрос и его имя " + "<b>" + request.getRemoteAddr() + "  " + request.getRemoteUser() + "</b>" + "</p>");
        pw.println("<p>Имя метода доступа к ресурсам, на основе которого построен запрос " + "<b>" + request.getMethod() + "</b>" + "</p>");
        pw.println("<p>URL-адрес, который клиент использовал для выполнения запроса " + "<b>" + request.getRequestURL() + "</b>" + "</p>");
        pw.println("<p>часть URL-адреса этого запроса, которая вызывает сервлет " + "<b>" + request.getServletPath() + "</b>" + "</p>");
        pw.println("<p>Возвращает любую дополнительную информацию о пути, связанную с URL-адрес, который клиент отправил при выполнении этого запроса " + "<b>" + request.getPathInfo() + "</b>" + "</p>");
        pw.println("<p>Информация о заголовках");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String headerValues = request.getHeader(name);
            pw.println(name + ":  " + headerValues);
        }
        pw.println("</p>");
        pw.println("</html>");
    }
}
