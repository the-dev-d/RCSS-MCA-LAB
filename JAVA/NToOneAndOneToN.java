import java.util.Scanner;

class NToOneAndOneToN {


    public static void printNToOne(int n) {

        //also works for negatives

        System.out.print(n + ", ");
        if (n > 1) 
            printNToOne(n-1);
        else if(n < 1)
            printNToOne(n+1);
    }

    public static void printOneToN(int n) {;

        //also works for negatives

        if(n>1)
            printOneToN(n-1);
        else if(n<1)
            printOneToN(n+1);

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
