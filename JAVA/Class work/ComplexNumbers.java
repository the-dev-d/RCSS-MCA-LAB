import java.util.Scanner;

class Complex {
    private double r;
    private double i;

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter real part: ");
        r = scanner.nextDouble();
        System.out.print("Enter imaginary part: ");
        i = scanner.nextDouble();
    }

    public void disp() {
        System.out.println("Complex Number: " + r + " + " + i + "i");
    }

    public Complex add(Complex other) {
        Complex result = new Complex();
        result.r = this.r + other.r;
        result.i = this.i + other.i;
        return result;
    }

    public Complex mult(Complex other) {
        Complex result = new Complex();
        result.r = (this.r * other.r) - (this.i * other.i);
        result.i = (this.r * other.i) + (this.i * other.r);
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Complex complex1 = new Complex();
        complex1.read();

        Complex complex2 = new Complex();
        complex2.read();

        System.out.println("Entered Complex Numbers:");
        complex1.disp();
        complex2.disp();

        System.out.println("Addition Result:");
        Complex additionResult = complex1.add(complex2);
        additionResult.disp();

        System.out.println("Multiplication Result:");
        Complex multiplicationResult = complex1.mult(complex2);
        multiplicationResult.disp();

        scanner.close();
    }
}
