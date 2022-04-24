package sapegina.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sapegina.model.User;
import sapegina.requests.AuthRequests;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            AuthRequests ar = new AuthRequests();
            String status = ar.checkUser(login, password);
            if (!Objects.equals(status, "null")) {
                User user = new User(login, password, status);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                Cookie cookie = new Cookie(login, status);
                cookie.setMaxAge(60 * 60 * 24);//-1 - когда закрыть браузер удалится
                response.addCookie(cookie);
                response.sendRedirect("index.jsp");
            }
            else {
                request.setAttribute("message", "Incorrect login or password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
