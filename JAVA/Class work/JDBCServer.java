import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


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

    void changePassword(String username, String password) throws SQLException {
        statement.executeUpdate("UPDATE login SET password = '" + password + "' WHERE username = '" + username + "'");
    }

    void register(String username, String password, String name) throws SQLException {
        statement.executeUpdate("INSERT INTO login(name, username, password) VALUES ('" + name + "', '" + username + "', '" + password + "')");
    }
}

public class JDBCServer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Database database = new Database("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/java?characterEncoding=utf8", "root", "");
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                System.out.println("Server started at port 8080 ...");
                Socket socket = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                while (true) {

                    String username = "", password = "";
                    System.out.println("Waiting for input");
                    String inputString = bufferedReader.readLine();
                    System.out.println("recieved " + inputString );

                    String components[] = inputString.split(":");
                    String command = components[0];
                    inputString = components[1].trim();
                    String inputs[] = inputString.split(" ");
                    username = inputs[0];
                    password = inputs[1];

                    switch (command) {
                        case "LOGIN":
                            User user = database.login(username, password);
                            if (user != null) {
                                bufferedWriter.write("Login successful, Welcome " + user.name + "!");
                                bufferedWriter.newLine();
                                bufferedWriter.flush();
                            } else {
                                bufferedWriter.write("Login failed");
                                bufferedWriter.newLine();
                                bufferedWriter.flush();
                            }
                            break;

                        case "CHANGE_PASSWORD":
                            database.changePassword(username, password);
                            bufferedWriter.write("Password changed successfully");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            break;
                    
                        case "REGISTER":
                            database.register(username, password, inputs[2]);
                            bufferedWriter.write("Registration successful");
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                            break;

                        default:
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