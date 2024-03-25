import java.sql.*;

class JDBCWarning {

    static final String JDBC_URL = "jdbc:mysql://localhost:3306/JDBC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM ErroringTable");

            SQLWarning warning = statement.getWarnings();
            if (warning != null) {
                System.out.println("SQLWarning detected:");
                while (warning != null) {
                    System.out.println("Message: " + warning.getMessage());
                    System.out.println("SQLState: " + warning.getSQLState());
                    System.out.println("Vendor Error Code: " + warning.getErrorCode());
                    warning = warning.getNextWarning();
                }
            } else {
                System.out.println("No SQLWarning detected.");
            }

        } catch (SQLException e) {
            System.err.println("SQLException occurred:");
            System.err.println("Message: " + e.getMessage());
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Vendor Error Code: " + ((SQLException) e).getErrorCode());
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
         finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
