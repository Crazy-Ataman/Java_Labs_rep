package mypackage;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@WebServlet(name = "SecondServlet", value = "/SecondServlet")
public class SecondServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "SecondServlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Time: "+ DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now()) + "</h1>");
        out.println(getRequestInfo(request, response));
        out.println("<p>"+"Information from header:"+"</p>");
        out.println(getHeaderInfo(request));
        out.println("</body></html>");
    }

    public String getRequestInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String res = "";
       res+= "<p>"+"метод доступа    " +  request.getMethod()+"</p>";
       res+= "<p>"+"URL    "+  request.getRequestURL()+"</p>";
       res+= "<p>"+"Протокол    "+  request.getProtocol()+"</p>";
       res+= "<p>"+"IP-адреса клиента, от имени которого пришел запрос"
                +  request.getRemoteAddr()+"</p>";
        res += "<p>"+"Имя клиента " +  request.getRemoteHost() + "   "
                +  request.getRemoteUser()+"</p>";
        res+="<p>"+"Номер порта " +  request.getRemotePort()+"</p>";
        res+="<p>"+"Cтрока HTTP-запроса  " + request.getQueryString()+"</p>";
        res+="<p>"+"Имя и порт сервера  " +  request.getServerName() +
                "  " +  request.getServerPort()+"</p>";
        res += "<p>"+"Путь   " +  request.getContextPath()+"</p>";
        res +=  "<p>"+request.getScheme()+"</p>";
        return res;
    }

    public String getHeaderInfo(HttpServletRequest request) {
        String result = "";
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = e.nextElement();
            String value = request.getHeader(name);
            result+="<p>"+name+" = "+value+"</p>";
        }
        return result;
    }
    public void destroy() {
    }
}
