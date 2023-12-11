import java.util.Scanner;

class MaxOfThree {

    public static int findLargest(int a, int b) {
        return a > b ? a : b;
    }
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int a,b,c;

        System.err.println("Enter three numbers : ");

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        int largest = findLargest(a, findLargest(b,c));

        System.out.println("Greater is : "+largest);

        scanner.close();

    }
}