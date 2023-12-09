import java.util.Scanner;

class SumOfSeries {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = scanner.nextInt();

        int term = 0, sum = 0;
        for(int i=1; i<= n; i++) {
            term+=i;
            sum+=term;
        }

        System.out.println(sum);
    }
}
