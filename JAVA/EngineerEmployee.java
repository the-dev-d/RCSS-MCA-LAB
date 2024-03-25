import java.util.Scanner;

class Employee {
    public void display() {
        System.out.println("Name of class is Employee.");
    }

    public void calcSalary() {
        System.out.println("Salary of employee is 10000.");
    }
}

class Engineer extends Employee {
    
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee emp = new Engineer();

        // Calling display() and calcSalary() methods
        emp.display();
        emp.calcSalary();

        scanner.close();
    }
}
