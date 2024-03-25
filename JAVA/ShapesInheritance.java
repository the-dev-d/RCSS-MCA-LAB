interface Area {
    double calculateArea();
}

interface Volume {
    double calculateVolume();
}

class Shape {
    String name;

    // Constructor with name parameter
    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Circle extends Shape implements Area {
    double radius;

    // Constructor with radius parameter
    public Circle(double r) {
        super("Circle"); // Hardcoded name for Circle
        this.radius = r;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Square extends Shape implements Area {
    double side;

    // Constructor with side parameter
    public Square(double s) {
        super("Square"); // Hardcoded name for Square
        this.side = s;
    }

    public double calculateArea() {
        return side * side;
    }
}

class Cylinder extends Circle implements Volume {
    double height;

    // Constructor with height and radius parameters
    public Cylinder(double h, double r) {
        super(r); // Hardcoded name for Cylinder
        this.height = h;
    }

    public double calculateVolume() {
        return calculateArea() * height;
    }
}

class Sphere extends Circle implements Volume {
    // Constructor with radius parameter
    public Sphere(double r) {
        super(r); // Hardcoded name for Sphere
    }

    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}

class Cube extends Square implements Volume {
    // Constructor with side parameter
    public Cube(double s) {
        super(s); // Hardcoded name for Cube
    }

    public double calculateVolume() {
        return Math.pow(side, 3);
    }
}

class Glome extends Sphere {
    // Constructor with radius parameter
    public Glome(double r) {
        super(r); // Hardcoded name for Glome
    }

    public double calculateVolume() {
        return 0.5 * Math.PI * Math.PI * Math.pow(radius, 4);
    }
}

class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("Area of " + circle.getName() + ": " + circle.calculateArea());

        Square square = new Square(4.0);
        System.out.println("Area of " + square.getName() + ": " + square.calculateArea());

        Cylinder cylinder = new Cylinder(6.0, 3.0);
        System.out.println("Volume of " + cylinder.getName() + ": " + cylinder.calculateVolume());

        Sphere sphere = new Sphere(4.0);
        System.out.println("Volume of " + sphere.getName() + ": " + sphere.calculateVolume());

        Cube cube = new Cube(3.0);
        System.out.println("Volume of " + cube.getName() + ": " + cube.calculateVolume());

        Glome glome = new Glome(2.0);
        System.out.println("Volume of " + glome.getName() + ": " + glome.calculateVolume());
    }
}
