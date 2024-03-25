import java.sql.*;
import java.util.Scanner;

class JDBCInsertDepartment {
    static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            // connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            System.out.println("Enter Department Number:");
            int departmentNumber = scanner.nextInt();

            System.out.println("Enter Department Name:");
            String departmentName = scanner.next();

            System.out.println("Enter Department Location:");
            String departmentLocation = scanner.next();

            // String procedureCall = "{CALL insert_department(?, ?, ?)}";
            // callableStatement = connection.prepareCall(procedureCall);

            // callableStatement.setInt(1, departmentNumber); 
            // callableStatement.setString(2, departmentName); 
            // callableStatement.setString(3, departmentLocation); 

            // callableStatement.execute();
            System.out.println("Stored procedure executed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
                scanner.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
