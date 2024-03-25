import java.sql.*;

public class JDBCCreate {
    // JDBC URL, username, and password for MySQL
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/JDBC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");

            // Create Department table
            statement = connection.createStatement();
            String createDepartmentTableSQL =
                    "CREATE TABLE Department (" +
                            "dno INT PRIMARY KEY," +
                            "dname VARCHAR(50)," +
                            "dloc VARCHAR(50))";
            statement.executeUpdate(createDepartmentTableSQL);
            System.out.println("Department table created successfully.");

            // Create Emp table
            String createEmpTableSQL =
                    "CREATE TABLE Emp (" +
                            "eno INT PRIMARY KEY," +
                            "ename VARCHAR(50)," +
                            "esal DECIMAL(10, 2)," +
                            "dno INT," +
                            "CONSTRAINT fk_department FOREIGN KEY (dno) REFERENCES Department(dno))";
            statement.executeUpdate(createEmpTableSQL);
            System.out.println("Emp table created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close statement and connection
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
