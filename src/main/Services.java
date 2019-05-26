package main;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import static main.ConnectionConfiguration.getConnection;

public class Services {
    public static String createAccount(User user) {
        ArrayList<String> usernames = ConnectionConfiguration.getAllUsers();
        if (usernames.contains(user.getEmail())) {
            return "Email already exists. Please insert another email.";
        }
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            return "Password has to contain at least 8 characters. Please insert another password.";
        }
        user.insertUserInDB(user);
        return "Account has been successfully created.";
    }
    public static String login(String email, String passwordLogin) {

        ArrayList<String> usernames = ConnectionConfiguration.getAllUsers();
        if(!usernames.contains(email)) {
            return "Username is not correct.\nPlease insert your username again.";
        }

        String password = ConnectionConfiguration.getPassword(email);
        if (!passwordLogin.equals(password))
            return "Password is not correct.\nPlease insert your password again.";

        return "Login successful";
    }
    public static StringBuffer movieArrayToString(ArrayList<Movie> movies){
        StringBuffer stringBuffer = new StringBuffer();
        for(Movie movie : movies)
            stringBuffer.append("Movie Id: " + movie.getId() + "    " +
                    "Movie name: " + movie.getName() + "   " +
                    "Movie Price: " + movie.getPrice() + "    " +
                    "Movie Format: " + movie.getFormat() + "    " +
                    "Date: " + movie.getDate() + "    " +
                    "Room: " + movie.getRoom() + "\n        ");
        return stringBuffer;
    }


}
