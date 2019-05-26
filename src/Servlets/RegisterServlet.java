package Servlets;

import main.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        int id = Integer.parseInt(req.getParameter("UserId"));;
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User newUser = new User(lastName, firstName, id, email, password );

    }
}
