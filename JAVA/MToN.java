import java.util.Scanner;

class MToN {
    
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int m, n, updator = 1;

        System.out.println("Enter M and N : \n");

        m = scanner.nextInt();
        n = scanner.nextInt();

        if(m>n) {
            updator = -1;
        }

        while(m != n + updator) {
            System.out.print(m + ", ");
            m+=updator;
        }
        scanner.close();
    }
}
