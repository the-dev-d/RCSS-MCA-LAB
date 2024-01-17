import java.util.Scanner;

class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Number add(Number other) {
        int sum = this.number + other.getNumber();
        return new Number(sum);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1Value = scanner.nextInt();
        Number num1 = new Number(num1Value);

        System.out.print("Enter the second number: ");
        int num2Value = scanner.nextInt();
        Number num2 = new Number(num2Value);

        Number sumResult = num1.add(num2);
        System.out.println("Sum: " + sumResult.getNumber());

        scanner.close();
    }
}
