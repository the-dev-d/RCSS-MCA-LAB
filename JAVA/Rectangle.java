import java.util.Scanner;

public class Rectangle {
    private double length;
    private double width;

    // Default constructor
    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    // Parameterized constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to set the dimensions of the rectangle
    public void setDimensions(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate the area of the rectangle
    public double calculateArea() {
        return length * width;
    }

    // Method to calculate the perimeter of the rectangle
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Method to compare the area of two rectangles
    public int sameArea(Rectangle otherRectangle) {
        double thisArea = this.calculateArea();
        double otherArea = otherRectangle.calculateArea();

        if (thisArea == otherArea) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first rectangle
        System.out.println("Enter the dimensions of the first rectangle:");
        System.out.print("Length: ");
        double length1 = scanner.nextDouble();
        System.out.print("Width: ");
        double width1 = scanner.nextDouble();
        Rectangle rectangle1 = new Rectangle(length1, width1);

        // Input for second rectangle
        System.out.println("Enter the dimensions of the second rectangle:");
        System.out.print("Length: ");
        double length2 = scanner.nextDouble();
        System.out.print("Width: ");
        double width2 = scanner.nextDouble();
        Rectangle rectangle2 = new Rectangle(length2, width2);

        // Output area and perimeter of both rectangles
        System.out.println("\nRectangle 1:");
        System.out.println("Area: " + rectangle1.calculateArea());
        System.out.println("Perimeter: " + rectangle1.calculatePerimeter());

        System.out.println("\nRectangle 2:");
        System.out.println("Area: " + rectangle2.calculateArea());
        System.out.println("Perimeter: " + rectangle2.calculatePerimeter());

        // Compare areas of both rectangles
        if (rectangle1.sameArea(rectangle2) == 1) {
            System.out.println("\nBoth rectangles have the same area.");
        } else {
            System.out.println("\nThe rectangles do not have the same area.");
        }

        scanner.close();
    }
}
