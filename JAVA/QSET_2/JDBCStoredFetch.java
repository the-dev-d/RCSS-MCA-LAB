import java.sql.*;

class JDBCStoredFetch {
    public static void main(String[] args) {
        try {
            // Establish connection
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "");

            // Prepare and execute the stored procedure
            CallableStatement callableStatement = connection.prepareCall("{call GET_EMPLOYEES()}");

            // Execute the stored procedure
            callableStatement.execute();

            // Fetch results
            ResultSet resultSet = callableStatement.getResultSet();

            // Loop through the result set and print each record
            while (resultSet.next()) {
                String employeeName = resultSet.getString("ename");
                double employeeSalary = resultSet.getDouble("esal");

                // Print results
                System.out.println("Employee Name: " + employeeName);
                System.out.println("Employee Salary: " + employeeSalary);
                System.out.println("---------------------------");
            }

            // Close connection, statement, and result set
            resultSet.close();
            callableStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
