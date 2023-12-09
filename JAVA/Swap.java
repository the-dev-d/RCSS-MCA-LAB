import java.io.DataInputStream;

class Swap {
    
    public static void main(String[] args) {
        DataInputStream in = new DataInputStream(System.in);
        try {

            System.err.println("Enter value for a and b : \n");
            int a, b;
            a = Integer.parseInt(in.readLine());
            b = Integer.parseInt(in.readLine());
            System.out.println("Before Swap \na: "+a+"\nb: "+b);

            int temp = a;
            a = b;
            b = temp;

            System.out.println("After Swap \na: "+a+"\nb: "+b);


        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
