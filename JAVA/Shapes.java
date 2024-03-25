// Abstract class Shape
abstract class Shape {
    // Abstract method
    public abstract void numberOfSides();
}

// Rectangle class extending Shape
class Rectangle extends Shape {
    // Implementation of numberOfSides method for Rectangle
    @Override
    public void numberOfSides() {
        System.out.println("A rectangle has 4 sides.");
    }
}

// Triangle class extending Shape
class Triangle extends Shape {
    // Implementation of numberOfSides method for Triangle
    @Override
    public void numberOfSides() {
        System.out.println("A triangle has 3 sides.");
    }
}

// Hexagon class extending Shape
class Hexagon extends Shape {
    // Implementation of numberOfSides method for Hexagon
    @Override
    public void numberOfSides() {
        System.out.println("A hexagon has 6 sides.");
    }
}

// Main class
class Main {
    public static void main(String[] args) {
        // Creating objects of Rectangle, Triangle, and Hexagon
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();
        Shape hexagon = new Hexagon();

        // Calling numberOfSides method for each shape
        rectangle.numberOfSides();
        triangle.numberOfSides();
        hexagon.numberOfSides();
    }
}
