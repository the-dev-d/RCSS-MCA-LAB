import java.io.DataInputStream;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


class PublicChatClient {
    
    public static void main(String[] args) {
        
        String username;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        try {
            Socket socket = new Socket("localhost", 5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(username + " joined the chat!");
            DataInputStream read = new DataInputStream(System.in);

            while (true) {
                if(read.available() > 0) {
                    String message = read.readLine();
                    if (message.equals("COMMAND:exit")) {
                        out.writeUTF(username + " left the chat!");
                        return;
                    }
                    else {
                        out.writeUTF(username + ": " + message);
                    }
                }
                if (in.available() > 0) {
                    System.out.println(in.readUTF());
                }
            }
        } catch(IOException e) {
        e.printStackTrace();
        }
    }
}