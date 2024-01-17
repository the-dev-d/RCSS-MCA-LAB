import java.util.InputMismatchException;
import java.util.Scanner;

class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            int result = divideNumbers(num1, num2);
            System.out.println("Result of division: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            scanner.close();
        }
    }

    private static int divideNumbers(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return numerator / denominator;
    }
}
