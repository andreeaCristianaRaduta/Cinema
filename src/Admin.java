import jdk.swing.interop.SwingInterOpUtils;

import java.sql.Connection;
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
         Connection conn = ConnectionConfiguration.getConnection();
         Statement stmt = null;
         Scanner sc = new Scanner(System.in);
         System.out.println("Room name");
         String roomName = sc.next();
         int nrOfS = 30;
         try {
             stmt = conn.createStatement();
         } catch (SQLException e) {
             e.printStackTrace();
         }

         String sql = " INSERT INTO room  VALUES ( " + "\"" + roomName +
                 "\"" + "," + "\"" + nrOfS + "\"" + ") ";
         try {
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

     //public void deleteMovie()

     //public void editMovie()


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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql1 = " INSERT INTO movie  VALUES ( " + "\"" + id +
                "\"" + "," + "\"" + name +
                "\"" + "," + "\"" + price +
                "\"" + "," + "\"" + format +
                "\"" + "," + "\"" + date +
                "\"" + "," + "\"" + roomName + "\"" + ") ";
        try {
            stmt.executeUpdate(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


 }
