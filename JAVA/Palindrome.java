import java.util.Scanner;

class Palindrome {

    static int makeReverse(Integer number) {

        return Integer.parseInt(new StringBuilder(number.toString()).reverse().toString());
    }

    static int checkPalindrome(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int number = scanner.nextInt();
        int reverse = Palindrome.makeReverse(number);

        if(Palindrome.checkPalindrome(number, reverse) == 1) 
            System.out.println("Palindrome");
        else 
            System.out.println("Not palindrome");

        scanner.close();
    }
}