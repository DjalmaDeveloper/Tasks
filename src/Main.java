import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/tasks";

        // Database Credentials
        String username = "tester";
        String password = "db@Tester123";

        // Establish the connection
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
