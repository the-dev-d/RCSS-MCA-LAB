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
                System.out.println("Enter username: ");
                String username = scanner.nextLine();
                System.out.println("Enter password: ");
                String password = scanner.nextLine();

                bufferedWriter.write(username + " " + password);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("Authenticating ...");
                String response = bufferedReader.readLine();

                System.out.println(response);

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
