import java.sql.*;

class JDBCConnection {
    private String jdbcUrl;
    private String username;
    private String password;
    private Connection connection;

    // Constructor to initialize JDBC URL, username, and password
    public JDBCConnection(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    // Method to connect to the database
    public void connect() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Connected to the database.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the database connection
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Example of how to use this class
    public static void main(String[] args) {
        // Create an instance of DatabaseConnection
        JDBCConnection dbConnection = new JDBCConnection("jdbc:mysql://localhost:3306/JDBC",
                "root", "");

        // Connect to the database
        dbConnection.connect();

        // Perform database operations...

        // Close the database connection
        dbConnection.close();
    }
}
