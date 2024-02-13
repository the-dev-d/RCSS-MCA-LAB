import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class User {
    String username;
    String password;
    String name;

    User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}

class Database {

    Connection connection;
    Statement statement;

    Database(String driver, String connectionString, String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        connection = DriverManager.getConnection(connectionString, username, password);
        statement = connection.createStatement();
    }

    User login(String username, String password) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'");
        if (resultSet.next()) {
            return new User(resultSet.getString("name") ,resultSet.getString("username"), resultSet.getString("password"));
        }
        return null;
    }
}

public class JDBCLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Database database = new Database("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/java?characterEncoding=utf8", "root", "");
            try {
                while (true) {
                    String username = "", password = "";

                    System.out.println("Enter username : ");
                    username = scanner.nextLine();
                    System.out.println("Enter password : ");
                    password = scanner.nextLine();

                    User user;
                    if ((user = database.login(username, password)) != null) {
                        System.out.println("Login successful, Welcome " + user.name + "!");
                    } else {
                        System.out.println("Login failed");
                    }

                    System.out.println("Do you want to continue? (y/n) : ");
                    String option = scanner.nextLine();
                    if (option.equals("n")) {
                        break;
                    }
                    if(option.equals("y")) {
                        continue;
                    }else {
                        System.out.println("Invalid option");
                        break;
                    }
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }finally {
                database.connection.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            scanner.close();
        }   
    }
}