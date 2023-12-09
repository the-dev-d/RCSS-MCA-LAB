import java.io.DataInputStream;

class SumOf2 {
    
    public static void main(String[] args) {

        DataInputStream in = new DataInputStream(System.in);
        try {

            System.err.println("Enter value for a and b : \n");
            int a, b;
            a = Integer.parseInt(in.readLine());
            b = Integer.parseInt(in.readLine());
            System.out.println("Sum of "+a+" and "+b+" is "+ (a+b));

        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
