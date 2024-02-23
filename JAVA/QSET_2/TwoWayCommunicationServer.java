import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

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
        return dataInputStream.readLine();
    }

    void close() throws IOException {
        socket.close();
    }

}

class ChatRoomServer {

    public static void main(String[] args) {

        try {

            String message = "";
            ServerSocket serverSocket = new ServerSocket(8008);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a username : ");
            String username = scanner.nextLine();

            Socket socket = serverSocket.accept();
            ChatServerSocket chatServerSocket = new ChatServerSocket(socket);

            chatServerSocket.sendMessage("You joined " + username + " server");
            message = chatServerSocket.getMessage();
            System.out.println(message);

            chatServerSocket.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
