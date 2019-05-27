package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Services {

    private static User loggedUser;

    public static String createAccount(User user) {
        ArrayList<String> usernames = ConnectionConfiguration.getAllEmails();
        if (usernames.contains(user.getEmail())) {
            return "Email already exists. Please insert another email.";
        }
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            return "Password has to contain at least 8 characters. Please insert another password.";
        }
        insertUserInDB(user);
        return "Account has been successfully created.";
    }

    public static String login(String email, String passwordLogin) {

        ArrayList<String> usernames = ConnectionConfiguration.getAllEmails();
        if (!usernames.contains(email)) {
            return "Username is not correct.\nPlease insert your username again.";
        }

        String password = ConnectionConfiguration.getPassword(email);
        if (!passwordLogin.equals(password))
            return "Password is not correct.\nPlease insert your password again.";

        return "Login successful";
    }

    public static StringBuffer movieArrayToString(ArrayList<Movie> movies) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Movie movie : movies)
            stringBuffer.append("Movie Id: " + movie.getId() + "    " +
                    "Movie name: " + movie.getName() + "   " +
                    "Movie Price: " + movie.getPrice() + "    " +
                    "Movie Format: " + movie.getFormat() + "    " +
                    "Date: " + movie.getDate() + "    " +
                    "Room: " + movie.getRoom() + "\n        ");
        System.out.println(stringBuffer);
        return stringBuffer;
    }

    public static String insertReservationInDB(Reservation res) {
        try (Connection conn = ConnectionConfiguration.getConnection()) {

            PreparedStatement preparedStatement = conn.prepareStatement(" INSERT INTO reservation(Movie, idUser)  VALUES (?,?)");
            String movieName = res.getMovie().getName();
            preparedStatement.setString(1, movieName);
            preparedStatement.setInt(2, Services.getLoggedUser().getUserId());
            preparedStatement.executeUpdate();
            return "Succes!";
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return "Reservation not completed!";
    }

    public static void getUserByEmail(String email) {          //gasesc user ul conectat
        for (User user : ConnectionConfiguration.getAllUsersFromDB()) {
            if (user.getEmail().equals(email)) {
                loggedUser = user;
                break;
            }
        }
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void insertUserInDB(User user) {
        try {
            Connection conn = ConnectionConfiguration.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("Insert into user(firstName, lastName, email, password)" +
                    " values (?,?,?,?) ");

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
