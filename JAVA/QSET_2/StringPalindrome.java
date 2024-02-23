import java.util.Scanner;

public class StringPalindrome {

    static boolean checkPalindrome(String input) {

        return input.equals(new StringBuffer(input).reverse().toString());
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word : ");
        String input = scanner.next();

        if (checkPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }

}
