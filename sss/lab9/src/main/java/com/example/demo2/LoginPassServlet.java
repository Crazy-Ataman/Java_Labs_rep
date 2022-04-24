package com.example.demo2;

import com.example.demo2.DB.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginPass", value = "/loginPass")
public class LoginPassServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        HttpSession session =request.getSession();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DB dataBase = new DB();
            //dataBase.FillTableUsers();
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
            if(dataBase.isUser(username, password, role)){
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                getServletContext().getRequestDispatcher("/welcome.jsp").forward(request,response);
            }
            else {
                getServletContext().getRequestDispatcher("/registerForm.jsp").forward(request,response);
            }

            dataBase.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        HttpSession session =request.getSession();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DB dataBase = new DB();
            //dataBase.FillTableUsers();
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
            if(dataBase.isUser(username, password, role)){
                session.setAttribute("username", username);
                session.setAttribute("role", role);
                getServletContext().getRequestDispatcher("/welcome.jsp").forward(request,response);
            }
            else {
                getServletContext().getRequestDispatcher("/registerForm.jsp").forward(request,response);
            }

            dataBase.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
