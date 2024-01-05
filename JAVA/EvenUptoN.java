import java.util.Scanner;

class SequenceGenerator {


    public static void evenTo(int n) {

        for(int i=2; i<=n; i+=2) {
            System.out.print(i + ", ");
        }
    }

}

class EvenUptoN {

    public static void main(String args[]) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = scanner.nextInt();

        SequenceGenerator.evenTo(n);

    }
}
