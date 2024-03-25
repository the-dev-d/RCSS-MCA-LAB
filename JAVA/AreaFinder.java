import java.util.Scanner;

public class AreaFinder {
    private double area;
    private String shape;

    // Constructor for Circle
    public AreaFinder(double radius) {
        this.shape = "Circle";
        this.area = calculateCircleArea(radius);
    }

    // Overloaded constructor for Rectangle or Triangle
    public AreaFinder(double dimension1, double dimension2, boolean isRectangle) {
        if (isRectangle) {
            this.shape = "Rectangle";
            this.area = calculateRectangleArea(dimension1, dimension2);
        } else {
            this.shape = "Triangle";    
            this.area = calculateTriangleArea(dimension1, dimension2);
        }
    }

    // Overloaded constructor for Trapezoid
    public AreaFinder(double topSide, double bottomSide, double height) {
        this.shape = "Trapezoid";
        this.area = calculateTrapezoidArea(topSide, bottomSide, height);
    }

    // Method to calculate area of Circle
    private double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Method to calculate area of Rectangle
    private double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    // Method to calculate area of Triangle
    private double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    // Method to calculate area of Trapezoid
    private double calculateTrapezoidArea(double topSide, double bottomSide, double height) {
        return 0.5 * (topSide + bottomSide) * height;
    }

    // Method to display area
    public void displayArea() {
        System.out.println("Shape: " + shape);
        System.out.println("Area: " + area);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the shape:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("4. Trapizoid");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                AreaFinder circle = new AreaFinder(radius);
                circle.displayArea();
                break;
            case 2:
                boolean rectangleBool = true;
                System.out.print("Enter the base : ");
                double width = scanner.nextDouble();
                System.out.print("Enter the height : ");
                double breadth = scanner.nextDouble();
                AreaFinder rectangle = new AreaFinder(width, breadth, rectangleBool);
                rectangle.displayArea();
                break;

            case 3:
                boolean triangleBool = false;
                System.out.print("Enter the base : ");
                double base = scanner.nextDouble();
                System.out.print("Enter the height : ");
                double height = scanner.nextDouble();
                AreaFinder triangle = new AreaFinder(base, height, triangleBool);
                triangle.displayArea();
                break;

            case 4:
                System.out.print("Enter the length of the top side of the trapezoid: ");
                double topSide = scanner.nextDouble();
                System.out.print("Enter the length of the bottom side of the trapezoid: ");
                double bottomSide = scanner.nextDouble();
                System.out.print("Enter the height of the trapezoid: ");
                double heightTrapezoid = scanner.nextDouble();
                AreaFinder trapezoid = new AreaFinder(topSide, bottomSide, heightTrapezoid);
                trapezoid.displayArea();
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
