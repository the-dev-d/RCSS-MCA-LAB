import java.util.Scanner;

class SumOfNEven {
    
    static int n;
    static int sum;

    static void findSum() {
        sum = 0;
        for(int i=2; i<= n*2; i+=2) {
            sum+=i;
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value for n : ");
        n = scanner.nextInt();

        SumOfNEven.findSum();

        System.out.println(sum);

        scanner.close();
    }
}
