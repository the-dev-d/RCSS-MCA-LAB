import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.net.*;

class ClientHandler extends Thread {

    private DataInputStream in;

    public ClientHandler(Socket socket, List<DataOutputStream> clients) throws IOException {
        in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        clients.add(out);
        System.out.println("New client connected! Total " + clients.size() + " clients");
    }
    public void run(){
        try {
            while (true) {
                String message = in.readUTF();
                PublicChatServer.broadcast(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PublicChatServer {

    public static List<DataOutputStream> clients = new ArrayList<>();

    public static void main(String[] args) {
        
        try {
            System.out.println("Server started");
            ServerSocket server = new ServerSocket(5000);
            while (true) {
                Socket socket = server.accept();
                ClientHandler client = new ClientHandler(socket, clients);
                client.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void broadcast(String message) throws IOException {
        for (int i=0; i<clients.size(); i++){
            clients.get(i).writeUTF(message);
        }
    }
}