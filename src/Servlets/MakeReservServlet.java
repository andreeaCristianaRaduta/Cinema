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
import java.sql.SQLException;

public class MakeReservServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("idMovie"));
            Movie mv = ConnectionConfiguration.findMovieById(id);
            Reservation reservation = new Reservation(mv, Services.getLoggedUser().getUserId());
            Services.getLoggedUser().getRezervations().add(reservation);   //o adaug in vectorul de rezx a userului curent
            req.setAttribute("rezervare", reservation);
            req.getRequestDispatcher("/movies.jsp").forward(req, resp);
            String reservationStatus = Services.insertReservationInDB(reservation);
            System.out.println(reservationStatus);
            if (reservationStatus.equals("Succes!")) {
                req.setAttribute("reservationStatus", reservationStatus);
                resp.sendRedirect("http://localhost:8080/Cinema_war_exploded/movies.jsp");
            }
            else {
                req.setAttribute("reservationStatus", reservationStatus);
                req.getRequestDispatcher("/movies.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
