import java.util.Scanner;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class JDBCLoginClient {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        try{
            Socket socket = new Socket("localhost", 8080);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                System.out.print("\033[H\033[2J");
                System.out.println("1. Login \n2.Register \n3.Quit \nChoose an option: ");
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Enter username: ");
                        scanner.nextLine();
                        String username = scanner.nextLine();
                        System.out.println("Enter password: ");
                        String password = scanner.nextLine();
                        bufferedWriter.write("LOGIN: " + username + " " + password);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        String response = bufferedReader.readLine();
                        System.out.println(response);
                        if(!response.equals("Login failed")){
                            inner:
                            while(true) {
                                scanner.nextLine();
                                System.out.println("1.Change password \n2.Logout \nChoose an option: ");
                                switch (scanner.nextInt()) {
                                    case 1:
                                        System.out.println("Enter new password: ");
                                        scanner.nextLine();
                                        String newPassword = scanner.nextLine();
                                        bufferedWriter.write("CHANGE_PASSWORD: " + username + " " + newPassword);
                                        bufferedWriter.newLine();
                                        bufferedWriter.flush();
                                        response = bufferedReader.readLine();
                                        System.out.println(response);
                                        break;
                                    case 2:
                                        bufferedWriter.write("LOGOUT");
                                        bufferedWriter.newLine();
                                        bufferedWriter.flush();
                                        break inner;
                                    default:
                                        break;
                                }
                            }
                        }
                        System.out.println(response);
                        break;

                    case 2:
                        System.out.println("Enter username: ");
                        scanner.nextLine();
                        username = scanner.nextLine();
                        System.out.println("Enter password: ");
                        password = scanner.nextLine();
                        System.out.println("Enter name: ");
                        String name = scanner.nextLine();
                        bufferedWriter.write("REGISTER: " + username + " " + password + " " + name);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        response = bufferedReader.readLine();
                        System.out.println(response);
                        break;

                    case 3:
                        bufferedWriter.write("QUIT");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        break;

                    default:
                        break;
                }
                
                System.out.println("Do you want to continue? (yes/no)");
                String choice = scanner.nextLine();
                
                if(choice.equals("no")){
                    bufferedWriter.write("QUIT");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
