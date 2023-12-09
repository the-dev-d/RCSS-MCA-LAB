import java.io.DataInputStream;

class MinimumOf3 {
    
    public static void main(String[] args) {
        
        DataInputStream in = new DataInputStream(System.in);
        try {

            System.err.println("Enter value for a, b and c : \n");
            int a, b, c, greater;
            a = Integer.parseInt(in.readLine());
            b = Integer.parseInt(in.readLine());
            c = Integer.parseInt(in.readLine());

            greater = a < b ? a < c ? a : c : b < c ? b : c;    //nested conditional operator

            System.err.println("Minimum is : "+greater);

        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
