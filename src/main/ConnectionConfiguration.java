package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import static jdk.internal.net.http.common.Utils.close;

public class ConnectionConfiguration {

    private static ArrayList<User> users;

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "Java123.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ArrayList<String> getAllEmails() {
        try (PreparedStatement statement = getConnection().prepareStatement("SELECT email from user")) {
            ResultSet resultSet = statement.executeQuery();
            ArrayList<String> emails = new ArrayList<>();
            while (resultSet.next()) {

                String email = resultSet.getString("email");
                emails.add(email);
            }
            resultSet.close();
            //System.out.println(emails);
            return emails;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<User> getAllUsersFromDB() {
        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * from user")) {
            ResultSet resultSet = statement.executeQuery();
            users = new ArrayList<>();

            while (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int id = resultSet.getInt("idUser");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                User user = new User(firstName, lastName, email, password);
                user.setIdUser(id);
                users.add(user);
            }
            resultSet.close();
            //System.out.println(emails);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPassword(String email) {

        try (PreparedStatement statement = getConnection().prepareStatement("SELECT password FROM user where email = ?")) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            String password = null;
            if (resultSet.next())
                password = resultSet.getString("password");
            resultSet.close();
            return password;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void verifyConnectios() {
        Connection connection = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            if (connection != null) {
                System.out.println("Connection established");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList<Movie> selectMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM movie")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int movieId = resultSet.getInt("id");
                String movieName = resultSet.getString("Name");
                double price = resultSet.getDouble("Price");
                String format = resultSet.getString("Format");
                Date date = resultSet.getDate("Date");
                String room = resultSet.getString("Room");
                Movie movie = new Movie(movieId, movieName, price, format, date, room);
                movies.add(movie);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //System.out.println(movies);
        return movies;
    }

    public static Movie findMovieById(int id) throws SQLException {
        try (PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM movie where id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int movieId = resultSet.getInt("id");
                String movieName = resultSet.getString("Name");
                double price = resultSet.getDouble("Price");
                String format = resultSet.getString("Format");
                Date date = resultSet.getDate("Date");
                String room = resultSet.getString("Room");
                Movie mv = new Movie(movieId, movieName, price, format, date, room);
                return mv;
            }
            return null;
        }
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}



