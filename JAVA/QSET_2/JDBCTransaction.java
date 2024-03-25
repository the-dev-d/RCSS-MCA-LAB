import java.sql.*;

class JDBCTransaction {
    static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            //connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            //connection.setAutoCommit(false);
            //statement = connection.createStatement();
            String updateQuery = "UPDATE Department SET dname = 'Civil Engineering' WHERE dname = 'Civil'";
            //statement.executeUpdate(updateQuery);

            //connection.commit();
            System.out.println("Transaction committed successfully.");

        } catch (Exception e) {
            // try {
            //     // if (connection != null) {
            //     //     connection.rollback();
            //     //     System.out.println("Transaction rolled back.");
            //     // }
            // } catch (SQLException ex) {
            //     ex.printStackTrace();
            // }
            e.printStackTrace();
        } finally {
            // try {
            //     if (statement != null) statement.close();
            //     if (connection != null) connection.close();
            // } catch (SQLException e) {
            //     e.printStackTrace();
            // }
        }
    }
}
