package Servlets;

import main.ConnectionConfiguration;
import main.Movie;
import main.Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class MoviesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Movie> categories = ConnectionConfiguration.selectMovies();
        req.setAttribute("movies", Services.movieArrayToString(categories));
        req.getRequestDispatcher("/movies.jsp").forward(req, resp);

    }
}
