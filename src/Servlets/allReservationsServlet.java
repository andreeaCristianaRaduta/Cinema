package Servlets;

import main.ConnectionConfiguration;
import main.Movie;
import main.Reservation;
import main.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class allReservationsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Reservation> allReservations = Services.getLoggedUser().getRezervations();
        req.setAttribute("allReservations", allReservations);
        //System.out.println(Services.movieArrayToString(movies));
        req.getRequestDispatcher("/movies.jsp").forward(req, resp);
        String allReservationStatus = "";
        if(allReservations != null){
            resp.sendRedirect("http://localhost:8080/Cinema_war_exploded/movies.jsp");
        }else{
            allReservationStatus = "N-avem";
            req.getRequestDispatcher("/movies.jsp").forward(req, resp);
        }
    }
}
