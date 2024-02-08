import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class ChatSocket {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ChatSocket(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream()); 
        this.out = new DataOutputStream(socket.getOutputStream()); 
    }

    String recieveMessage() throws IOException{
        return in.readUTF();
    }

    void sendMessage(String message) throws IOException{
        out.writeUTF(message);
    }

    boolean messageAvailable() throws IOException{
        return in.available() > 0;
    }
    void close() throws IOException{
        this.socket.close();
    }
}

public class ChatClient {
    public static void main(String[] args) {
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String username = "", message = "";
            System.out.println("Enter username : ");
            username = bufferedReader.readLine();
            ChatSocket chatSocket = new ChatSocket(new Socket("localhost", 8080));
            chatSocket.sendMessage(username + " joined");
            while(true){
                if(chatSocket.messageAvailable()){
                    message = chatSocket.recieveMessage();
                    if (!message.contains(":") && message.equals("QUIT")) {
                        chatSocket.close();
                        return;
                    }
                    System.out.println(message);
                }

                if(bufferedReader.ready()) {
                    message = bufferedReader.readLine();
                    if(message.equals("QUIT")) {
                        chatSocket.sendMessage("QUIT");
                        chatSocket.close();
                        return;
                    }
                    chatSocket.sendMessage(username + ": "+ message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
