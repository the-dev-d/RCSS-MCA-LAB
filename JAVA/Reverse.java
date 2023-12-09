import java.util.Scanner;

class Reverse {

  static Integer number;

  public static void reverseNumber() {
    number = Integer.parseInt(new StringBuilder(number.toString()).reverse().toString());
  }

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter number: ");
    number = scanner.nextInt();

    reverseNumber();
    System.out.println("Reverse is : " + number);

    scanner.close();
  }
}
