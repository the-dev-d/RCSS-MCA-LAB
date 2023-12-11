import java.util.Scanner;

class NToOneAndOneToN {


    public static void printNToOne(int n) {
        if(n == 0)
            return;

        System.out.print(n + ", ");
        printNToOne(n-1);
    }

    public static void printOneToN(int n) {
        if(n == 0)
            return;

        printOneToN(n-1);
        System.out.print(n + ", ");
    }
    
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter a number : ");
         int n = scanner.nextInt();
         
         
         printNToOne(n);
         System.out.println();
         printOneToN(n);

         scanner.close();
    }
}
