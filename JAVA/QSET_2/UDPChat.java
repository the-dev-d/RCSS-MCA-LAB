import java.io.*;
import java.net.*;

public class UDPChat {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            System.out.println("UDP Chat application");
            System.out.println("Local port: " + socket.getLocalPort());

            DataInputStream reader = new DataInputStream(System.in);

            System.out.println("Choose an option:");
            System.out.println("1. Connect");
            System.out.println("2. Listen");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter remote host name: ");
                    String host = reader.readLine();
                    System.out.print("Enter remote port number: ");
                    int remotePort = Integer.parseInt(reader.readLine());

                    while (true) {
                        InetAddress address = InetAddress.getByName(host); 
                        System.out.println("Enter message: ");  
                        String message = reader.readLine();
                        sendMessages(socket, address, remotePort, message);
                        receiveMessages(socket);
                    }
                case 2:
                    while (true) {
                        DatagramPacket packet = receiveMessages(socket);
                        System.out.println("Enter message: ");
                        String message = reader.readLine();
                        sendMessages(socket, packet.getAddress(), packet.getPort(), message);
                    }
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMessages(DatagramSocket socket, InetAddress address, int port, String message) throws IOException{
        byte[] sendData = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
        socket.send(sendPacket);
    }

    private static DatagramPacket receiveMessages(DatagramSocket socket) throws IOException {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Received message: " + receivedMessage);
        return receivePacket;
    }
}
