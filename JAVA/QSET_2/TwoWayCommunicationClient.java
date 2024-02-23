import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

class ChatServerSocket {

    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    ChatServerSocket(Socket socket) throws IOException {
        this.socket = socket;
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    void sendMessage(String message) throws IOException {
        this.dataOutputStream.writeUTF(message);
    }

    boolean isMessageAvailable() throws IOException {
        return dataInputStream.available() != 0;
    }

    String getMessage() throws IOException {
        return dataInputStream.readUTF();
    }

    void close() throws IOException {
        socket.close();
    }

}

class ChatRoomClient {

    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter username : ");
            String message, username = scanner.nextLine();

            Socket socket = new Socket("localhost", 8008);
            ChatServerSocket chatServerSocket = new ChatServerSocket(socket);

            message = chatServerSocket.getMessage();
            System.out.println(message);
            chatServerSocket.sendMessage(username + ": Hello devd");

        } catch (IOException e) {

            System.out.println(e);
        } finally {

        }
    }

}
