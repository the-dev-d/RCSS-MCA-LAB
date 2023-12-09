import java.util.Scanner;

class DigitSum {

  static Integer number;
  static Integer sum;

  public static void reverseNumber() {
    String digits[] = number.toString().split("");
    sum = 0;
    for(String digit: digits) {
        sum+=Integer.parseInt(digit);
    }
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number: ");
    number = scanner.nextInt();

    reverseNumber();
    System.out.println("Digit sum is : " + sum);

    scanner.close();
  }
}
