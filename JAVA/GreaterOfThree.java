import java.io.DataInputStream;

class GreaterOfThree {
    
    public static void main(String[] args) {
        
        DataInputStream in = new DataInputStream(System.in);
        try {

            System.err.println("Enter value for a, b and c : \n");
            int a, b, c, greater;
            a = Integer.parseInt(in.readLine());
            b = Integer.parseInt(in.readLine());
            c = Integer.parseInt(in.readLine());

            greater = a;
            if(b > greater)
                greater = b;
            if(c > greater)
                greater = c;

            System.err.println("Greater is : "+greater);

        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
