import java.util.Scanner;

class Employee {
    String name;
    int age;
    String phoneNumber;
    String address;
    double salary;

    // Constructor
    public Employee(String name, int age, String phoneNumber, String address, double salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nPhone Number: " + phoneNumber + "\nAddress: " + address + "\nSalary: $" + salary;
    }
}

class Officer extends Employee {
    String specialization;

    // Constructor
    public Officer(String name, int age, String phoneNumber, String address, double salary, String specialization) {
        super(name, age, phoneNumber, address, salary);
        this.specialization = specialization;
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() + "\nSpecialization: " + specialization;
    }
}

class Manager extends Employee {
    String department;

    // Constructor
    public Manager(String name, int age, String phoneNumber, String address, double salary, String department) {
        super(name, age, phoneNumber, address, salary);
        this.department = department;
    }

    // Override toString method
    @Override
    public String toString() {
        return super.toString() + "\nDepartment: " + department;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input values for Officer
        System.out.println("Enter details for Officer:");
        System.out.print("Name: ");
        String officerName = scanner.nextLine();
        System.out.print("Age: ");
        int officerAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Phone Number: ");
        String officerPhoneNumber = scanner.nextLine();
        System.out.print("Address: ");
        String officerAddress = scanner.nextLine();
        System.out.print("Salary: ");
        double officerSalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Specialization: ");
        String officerSpecialization = scanner.nextLine();

        // Create Officer object
        Officer officer = new Officer(officerName, officerAge, officerPhoneNumber, officerAddress, officerSalary, officerSpecialization);

        // Input values for Manager
        System.out.println("\nEnter details for Manager:");
        System.out.print("Name: ");
        String managerName = scanner.nextLine();
        System.out.print("Age: ");
        int managerAge = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Phone Number: ");
        String managerPhoneNumber = scanner.nextLine();
        System.out.print("Address: ");
        String managerAddress = scanner.nextLine();
        System.out.print("Salary: ");
        double managerSalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        System.out.print("Department: ");
        String managerDepartment = scanner.nextLine();

        // Create Manager object
        Manager manager = new Manager(managerName, managerAge, managerPhoneNumber, managerAddress, managerSalary, managerDepartment);

        scanner.close();

        // Print details using toString method
        System.out.println("\nOfficer Details:");
        System.out.println(officer);
        System.out.println("\nManager Details:");
        System.out.println(manager);
    }
}
