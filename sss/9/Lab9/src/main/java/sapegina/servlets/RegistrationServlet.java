package sapegina.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sapegina.requests.AuthRequests;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            AuthRequests ar = new AuthRequests();
            ar.addUser(login, password);
            response.sendRedirect("login.jsp"); // перенаправление на страницу входа
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
