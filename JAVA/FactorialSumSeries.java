import java.util.Scanner;

class FactorialSumSeries {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter n : ");
        int n = scanner.nextInt();

        int denom = 1;
        float sum = 0;
        for(int i=1; i<= n; i++) {
            
            denom = denom * i;
            sum += i/(float)denom;
        }

        System.out.println(sum);
    }

}
