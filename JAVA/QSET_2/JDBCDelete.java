import java.sql.*;

public class JDBCDelete {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/JDBC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String deleteQuery = "DELETE FROM Emp WHERE esal < ?";

            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setDouble(1, 10000); 
            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println(rowsDeleted + " records deleted successfully.");

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
