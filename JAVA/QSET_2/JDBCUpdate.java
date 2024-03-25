import java.sql.*;

public class JDBCUpdate {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/JDBC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            String updateQuery = "UPDATE Emp SET esal = ? WHERE ename = ?";

            preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setDouble(1, 15000); 
            preparedStatement.setString(2, "Rani"); 

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found for Rani.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
