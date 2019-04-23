import jdk.swing.interop.SwingInterOpUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

 public class Admin {
     private ArrayList<Movie> movies = new ArrayList<>();
     private ArrayList<Room> rooms = new ArrayList<>();
     private Reservation reservation;

     public void addRoom(){
         try {

             Connection conn = ConnectionConfiguration.getConnection();
             Statement stmt = null;
             Scanner sc = new Scanner(System.in);
             System.out.println("Room name");
             String roomName = sc.next();
             int nrOfS = 30;

             stmt = conn.createStatement();

             String sql = " INSERT INTO room  VALUES ( " + "\"" + roomName +
                     "\"" + "," + "\"" + nrOfS + "\"" + ") ";

             stmt.executeUpdate(sql);

         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public void editRoom(){
         Connection conn = ConnectionConfiguration.getConnection();
         Statement stmt = null;
         Scanner sc = new Scanner(System.in);
         System.out.println("What would you like to edit? seats-2 / name-1");
         Integer opt;
         opt = sc.nextInt();
         try {
             stmt = conn.createStatement();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         switch(opt){
             case 1:
                 System.out.println("Ex-name:");
                 String exName = sc.next();
                 System.out.println("New-name");
                 String newName = sc.next();
                 String sql = " UPDATE room SET name= " + "\"" + newName + "\"" + "WHERE name = " + "\"" + exName + "\"";
                 try {
                     stmt.executeUpdate(sql);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 break;
             case 2:
                 System.out.println("Room name:");
                 String name = sc.next();
                 System.out.println("New nr of Seats");
                 Integer newNr = sc.nextInt();
                 String sql1 = " UPDATE room SET nrOfSeats= " + "\"" + newNr + "\"" + "WHERE name = " + "\"" + name + "\"";
                 try {
                     stmt.executeUpdate(sql1);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 break;
         }

     }
     public void deleteRoom(){
         Connection conn = ConnectionConfiguration.getConnection();
         Statement stmt = null;
         Scanner sc = new Scanner(System.in);
         String sql = "SELECT * from room";

         try {
             stmt = conn.createStatement();
             stmt.executeQuery(sql);
             System.out.println("Numele salii pe care dorim s-o stergem:");
             String option;
             option = sc.next();
             PreparedStatement pstm = conn.prepareStatement( "DELETE FROM cinema.room WHERE name = ?");
             pstm.setString(1, option);
             pstm.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public void deleteMovie(){
         Connection conn = ConnectionConfiguration.getConnection();
         Statement stmt = null;
         Scanner sc = new Scanner(System.in);
         String sql = "SELECT * from movie";
         try {
             stmt = conn.createStatement();
             stmt.executeQuery(sql);
             System.out.println("Numele filmului pe care dorim s-o stergem:");
             String name;
             name = sc.next();
             PreparedStatement pstm = conn.prepareStatement( "DELETE FROM cinema.movie WHERE name = ?");
             pstm.setString(1, name);
             pstm.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public void editMovie(){
         Connection conn = ConnectionConfiguration.getConnection();
         Statement stmt = null;
         Scanner sc = new Scanner(System.in);
         System.out.println("What would you like to edit? ");
         System.out.println("1 - name/ 2 - price / 3 - format / 4 - data / 5 - room");
         Integer opt = sc.nextInt();
         try {
             stmt = conn.createStatement();
         } catch (SQLException e) {
             e.printStackTrace();
         }
         switch (opt){
             case 1:
                 System.out.println("Id:");
                 Integer theId = sc.nextInt();
                 System.out.println("New-name");
                 String newName = sc.next();
                 String sql = " UPDATE movie SET name= " + "\"" + newName + "\"" + "WHERE id = " + "\"" + theId + "\"";
                 try {
                     stmt.executeUpdate(sql);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 break;
             case 2:
                 System.out.println("Id:");
                 theId = sc.nextInt();
                 System.out.println("New price");
                 Double newPrice = sc.nextDouble();
                 String sql1 = " UPDATE movie SET price= " + "\"" + newPrice + "\"" + "WHERE id = " + "\"" + theId + "\"";
                 try {
                     stmt.executeUpdate(sql1);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 break;
             case 3:
                 System.out.println("Id:");
                 theId = sc.nextInt();
                 System.out.println("New format");
                 String newFormat = sc.next();
                 String sql2 = " UPDATE movie SET format= " + "\"" + newFormat + "\"" + "WHERE id = " + "\"" + theId + "\"";
                 try {
                     stmt.executeUpdate(sql2);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 break;
             case 4:
                 System.out.println("Id:");
                 theId = sc.nextInt();
                 System.out.println("New date");
                 String day = sc.next();
                 String hour = sc.next();
                 String newDate = day + " " + hour;
                 String sql3 = " UPDATE movie SET date= " + "\"" + newDate + "\"" + "WHERE id = " + "\"" + theId + "\"";
                 try {
                     stmt.executeUpdate(sql3);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 break;
             case 5:
                 System.out.println("Id:");
                 theId = sc.nextInt();
                 System.out.println("New room");
                 String newRoom = sc.next();
                 String sql4 = " UPDATE movie SET room= " + "\"" + newRoom + "\"" + "WHERE id = " + "\"" + theId + "\"";
                 try {
                     stmt.executeUpdate(sql4);
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 break;
         }
     }


    public void addMovie(){
        Connection conn = ConnectionConfiguration.getConnection();
        Statement stmt = null;
        Scanner sc = new Scanner(System.in); //Nu cred ca e corect sa avem un user cand aadaugam un nou film, dar am pus user susu pt ca
        System.out.println("Id of the movie");
        Integer id = sc.nextInt();
        System.out.println("Introduceti numele filmului:");
        String name = sc.next();
        System.out.println("Price:");
        String priceS = sc.next();
        Double price = Double.parseDouble(priceS);
        System.out.println("Introduceti formatul: twoD/threeD/fourDX/IMAX ");
        String format = sc.next();

        System.out.println("Date:");
        String day = sc.next();
        String hour = sc.next();
        String date = day + " " + hour;
        System.out.println("Room name");
        String roomName = sc.next();
        try {
            stmt = conn.createStatement();

            String sql1 = " INSERT INTO movie  VALUES ( " + "\"" + id +      //format data : 2019-04-23 20:00:00
                    "\"" + "," + "\"" + name +
                    "\"" + "," + "\"" + price +
                    "\"" + "," + "\"" + format +
                    "\"" + "," + "\"" + date +
                    "\"" + "," + "\"" + roomName + "\"" + ") ";
            stmt.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


 }
