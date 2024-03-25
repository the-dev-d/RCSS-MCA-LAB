import java.util.Scanner;

// Interface Operations
interface Operations {
    double PI = 3.14; // Constant

    double area(); // Method to calculate area
    double volume(); // Method to calculate volume
}

// Class Cylinder implementing Operations interface
class Cylinder implements Operations {
    double radius; // Radius of the cylinder
    double height; // Height of the cylinder

    // Constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Method to calculate the area of the cylinder
    public double area() {
        // Area = 2πrh + 2πr^2
        return 2 * PI * radius * height + 2 * PI * Math.pow(radius, 2);
    }

    // Method to calculate the volume of the cylinder
    public double volume() {
        // Volume = πr^2h
        return PI * Math.pow(radius, 2) * height;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for radius and height
        System.out.print("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();

        // Creating a Cylinder object with user input
        Cylinder cylinder = new Cylinder(radius, height);

        // Calculating and printing area and volume
        System.out.println("Area of the Cylinder: " + cylinder.area());
        System.out.println("Volume of the Cylinder: " + cylinder.volume());

        scanner.close();
    }
}
