package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import requests.DisciplineRequest;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateMethodServlet", value = "/UpdateMethodServlet")
public class UpdateMethodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String discipline = request.getParameter("discipline");
        try {
            DisciplineRequest disciplineRequest = new DisciplineRequest();
            disciplineRequest.updateDiscipline(name, discipline);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException | ServletException e) {
            request.setAttribute("Error code", e.fillInStackTrace());
            request.setAttribute("Error message", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
