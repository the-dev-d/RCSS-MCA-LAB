import java.util.Scanner;

class CircleArea {

  public static double radius;
  public static double area;

  public static void calculateArea() {
    area = Math.PI * radius * radius;
  }

  public static void main(String[] args) {

    System.out.println("Enter radius: ");
    Scanner scanner = new Scanner(System.in);
    radius = scanner.nextDouble();

    calculateArea();
    System.out.println("Area of circle: " + area);

    scanner.close();
  }
}
