package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class User {

    private String firstName, lastName;
    private Integer idUser;
    private String email;
    private String password;
    private Reservation res;
    private Movie movie;
    //        private boolean isStudent = false;
//        private boolean isChild = false;
//        private boolean isElder = false;
    private ArrayList<Reservation> rezervations = new ArrayList<>();

    public ArrayList<Reservation> getRezervations() {
        return rezervations;
    }

    public void setRezervations(ArrayList<Reservation> rezervations) {
        this.rezervations = rezervations;
    }

    public User() throws SQLException {
    }

    public User(String firstName, String lastName, String email, String password) throws SQLException {
        //putem sa pune boolean isChild, isStudent, isElder
        this.firstName = firstName;
        this.lastName = lastName;

        this.email = email;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUser(int id) {
        this.idUser = id;
    }

    public int getUserId() {
        return this.idUser;
    }

}
