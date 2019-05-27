package main;

public class Main {

    public static void main(String[] args) {
        //User user1 = new User();
        // user1.insertUserInDB();
       // Admin admin = new Admin();
        //admin.addRoom();;
        //admin.editMovie();
        ConnectionConfiguration cc = new ConnectionConfiguration();
        System.out.println(ConnectionConfiguration.selectMovies());

    }
}
