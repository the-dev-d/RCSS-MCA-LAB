import java.util.Scanner;

class Palindrome {

    public static boolean check(String word) {
        String reverse = new StringBuilder(word).reverse().toString();

        return word.equals(reverse);
    }

}

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: ");
        String word = scanner.next();

        if (Palindrome.check(word)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }

        scanner.close();
    }

}