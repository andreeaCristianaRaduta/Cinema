import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {

        public static Connection getConnection(){
            Connection connection = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema?useSSL=false", "root", "Java123.");
            }catch (Exception e){
                e.printStackTrace();
            }
            return connection;
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
    }


