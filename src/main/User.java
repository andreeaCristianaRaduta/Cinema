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
        private Integer id;
        private String email;
        private String password;
        private Reservation res;
        private Movie movie;
        private boolean isStudent = false;
        private boolean isChild = false;
        private boolean isElder = false;


        public User() {
        }

        public User(String firstName, String lastName, String email, String password) {
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

        public boolean isStudent() {
            return isStudent;
        }

        public void setStudent(boolean student) {
            isStudent = student;
        }

        public boolean isChild() {
            return isChild;
        }

        public void setChild(boolean child) {
            isChild = child;
        }

        public boolean isElder() {
            return isElder;
        }

        public void setElder(boolean elder) {
            isElder = elder;
        }

        /*public boolean inDataBase( String email ){
            //to be continued...
        }*/

        public void insertUserInDB(User user) {

            Connection conn = ConnectionConfiguration.getConnection();
            Statement stmt = null;
            Scanner sc = new Scanner(System.in);
//            System.out.println("Insert email");
//            email = sc.next();
//            System.out.println("Insert password");
//            password = sc.next();
//            System.out.println("Insert first name");
//            firstName = sc.next();
//            System.out.println("insert last name");
//            lastName = sc.next();
            try {
                stmt = conn.createStatement();
//                System.out.println(" Are you child?(Y/N) ");
//                String type = sc.next();
//                if( type == "Y" ) isChild = true;
//                else isChild = false;

//                System.out.println("Are you student?(Y/N)");
//                type = sc.next();
//                if( type == "Y" ) isStudent = true;
//                else isStudent = false;

//                System.out.println("Are you elder?(Y/N)");
//                type = sc.next();
//                if( type == "Y" ) isElder = true;
//                else isElder = false;

                String sql = " INSERT INTO user  VALUES ( " + "\"" + firstName +
                        "\"" + "," + "\"" + lastName +
                        "\"" + "," + "\"" + email +
                        "\"" + "," + "\"" + password + "\"" + ") ";
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Inserted records into the table...");
        }
        public void makeReservation(){
            Connection conn = ConnectionConfiguration.getConnection();
            Statement stmt = null;
            Scanner sc = new Scanner(System.in);
            String sql = "SELECT * FROM movie";
            try {
                stmt.executeQuery(sql);
                Integer option;
                option= sc.nextInt();

                System.out.println("How many people?");
                res.setNumberOfPeople(sc.nextInt());

                String sql2 = "INSERT INTO reservation  VALUES ( " + "\"" + option +
                        "\"" + "," + "\"" + movie.getDate() +
                        "\"" + "," + "\"" + movie.getName() +
                        "\"" + "," + "\"" + res.getNumberOfPeople() + "\"" + ") ";
                stmt.executeUpdate(sql2);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //reservation.ocupatingSeats(reservation.getNumberOfPeople());
        }

    /*
            else System.out.println("User exists! Try login.");
        }
    */
    }
