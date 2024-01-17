interface IShape {
    void draw();
    void move();
}

class Rectangle implements IShape {
    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    public void move() {
        System.out.println("Moving a rectangle");
    }
}

class Circle implements IShape {
    public void draw() {
        System.out.println("Drawing a circle");
    }

    public void move() {
        System.out.println("Moving a circle");
    }
}

class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        System.out.println("Invoking methods for Rectangle:");
        rectangle.draw();
        rectangle.move();

        System.out.println("\nInvoking methods for Circle:");
        circle.draw();
        circle.move();
    }
}
