import java.net.InetAddress;

class Test {


    public static void main(String[] args) throws Exception{
        

        InetAddress inetAddress = InetAddress.getByName("www.dhaivathlal.in");
        System.out.println("Host Name: " + inetAddress);

        System.out.println("IP Address: " + inetAddress.getHostAddress());
    }
}