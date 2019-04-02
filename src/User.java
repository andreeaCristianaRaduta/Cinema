import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User {
    private String firstName, lastName;
    private Integer id;
    private String email;
    private String password;

    private boolean isStudent = false;
    private boolean isChild = false;
    private boolean isElder = false;


    public User() {
    }

    public User(String firstName, String lastName, Integer id, String email, String password) {
        //putem sa pune boolean isChild, isStudent, isElder
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
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

    public void insertUserInDB() {

        Connection conn = ConnectionConfiguration.getConnection();
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert email");
        email = sc.next();
        System.out.println("Insert password");
        password = sc.next();
        System.out.println("Insert first name");
        firstName = sc.next();
        System.out.println("insert last name");
        lastName = sc.next();
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(" Are you child?(Y/N) ");
        String type = sc.next();
        if( type == "Y" ) isChild = true;
        else isChild = false;

        System.out.println("Are you student?(Y/N)");
        type = sc.next();
        if( type == "Y" ) isStudent = true;
        else isStudent = false;

        System.out.println("Are you elder?(Y/N)");
        type = sc.next();
        if( type == "Y" ) isElder = true;
        else isElder = false;

        String sql = " INSERT INTO user  VALUES ( " + "\"" + firstName +
                        "\"" + "," + "\"" + lastName +
                        "\"" + "," + "\"" + email +
                        "\"" + "," + "\"" + password + "\"" + ") ";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Inserted records into the table...");

    }
/*
        else System.out.println("User exists! Try login.");
    }
*/
}
