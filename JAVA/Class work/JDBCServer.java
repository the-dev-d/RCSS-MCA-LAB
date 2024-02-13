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
                    System.out.println("recieved" + inputString );

                    String[] inputs = inputString.split(" ");
                    if (inputs.length != 2) {
                        if (inputString.equals("QUIT")) {
                            socket.close();
                            serverSocket.close();
                        }
                        continue;
                    }
                    username = inputs[0];
                    password = inputs[1];

                    User user;
                    if ((user = database.login(username, password)) != null) {
                        bufferedWriter.write("Login successful, Welcome " + user.name + "!");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } else {
                        bufferedWriter.write("Login failed");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
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