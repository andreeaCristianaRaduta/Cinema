package Servlets;

import main.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String loginStatus = Services.login(email, password);

        Services.getUserByEmail(email);

        if (loginStatus.equals("Login successful"))
            resp.sendRedirect("http://localhost:8080/Cinema_war_exploded/movies.jsp");
        else {
            req.setAttribute("loginStatus", loginStatus);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
