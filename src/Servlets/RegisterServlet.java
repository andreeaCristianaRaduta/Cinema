package Servlets;

import main.Services;
import main.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User newUser = new User(lastName, firstName, email, password );
        String registerStatus = Services.createAccount(newUser);
        if(registerStatus.equals("Account has been successfully created.")) {
            resp.sendRedirect("http://localhost:8080/Cinema_war_exploded/movies.jsp");
            //HttpSession session = req.getSession();
        }
        else {
            req.setAttribute("registerStatus", registerStatus);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
