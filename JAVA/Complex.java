import java.util.Scanner;

public class Complex {
    private double real;
    private double imaginary;

    // Default constructor
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    // Parameterized constructor
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to set the real and imaginary parts
    public void setComplex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Method to add two complex numbers
    public Complex sum(Complex other) {
        double sumReal = this.real + other.real;
        double sumImaginary = this.imaginary + other.imaginary;
        return new Complex(sumReal, sumImaginary);
    }

    // Method to display the complex number
    public void displayComplex() {
        System.out.println(this.real + " + " + this.imaginary + "i");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the real and imaginary parts of the first complex number:");
        double real1 = scanner.nextDouble();
        double imaginary1 = scanner.nextDouble();
        Complex complex1 = new Complex(real1, imaginary1);

        System.out.println("Enter the real and imaginary parts of the second complex number:");
        double real2 = scanner.nextDouble();
        double imaginary2 = scanner.nextDouble();
        Complex complex2 = new Complex(real2, imaginary2);

        System.out.println("\nComplex number 1:");
        complex1.displayComplex();

        System.out.println("Complex number 2:");
        complex2.displayComplex();

        Complex sum = complex1.sum(complex2);
        System.out.println("\nSum of complex numbers:");
        sum.displayComplex();

        scanner.close();
    }
}
