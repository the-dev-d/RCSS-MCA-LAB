// Write a java program which created a class named employee having the following members. 
// Name, Age, Phone, Address, Salary. This also has a method called printSalary() which prints salary of employee. 
// Officer and Manager with classes specialization and department now create object of Officer and Manager and print.

import java.util.Scanner;

class Employee {

    private String name;
    private int age;
    private String phoneNumber;
    private float salary;

    Employee(
            String name,
            int age,
            String phoneNumber,
            float salary) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public void printSalary() {
        System.out.print(this.salary);
    }

    public void printEmployeeDetails() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Phone number : " + phoneNumber);
        System.out.println("Salary : ");
        this.printSalary();
    }
}

class Officer extends Employee {

    private String specialization;

    Officer(
            String name,
            int age,
            String phoneNumber,
            float salary,
            String specialization) {
        super(name, age, phoneNumber, salary);
        this.specialization = specialization;
    }

    public void printOfficer() {

        this.printEmployeeDetails();
        System.out.println("\nSpecialization : " + this.specialization);
    }
}

class Manager extends Employee {

    private String department;

    Manager(
            String name,
            int age,
            String phoneNumber,
            float salary,
            String department) {
        super(name, age, phoneNumber, salary);
        this.department = department;
    }

    public void printManager() {

        this.printEmployeeDetails();
        System.out.println("\nDepartment : " + this.department);
    }
}

class EmployeeManagerOfficer {

    public static void main(String[] args) {

        Officer officer;
        Manager manager;
        Scanner scanner = new Scanner(System.in);
        String name, phoneNumber, department, specialization;
        int age;
        float salary;

        System.out.println("====OFFICER=====");
        System.out.print("Name : ");
        name = scanner.nextLine();
        System.out.print("Age : ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.print("Phone Number : ");
        phoneNumber = scanner.nextLine();
        System.out.print("Salary : ");
        salary = Float.parseFloat(scanner.nextLine());
        System.out.print("Specialization : ");
        specialization = scanner.nextLine();
        officer = new Officer(name, age, phoneNumber, salary, specialization);

        System.out.println("====Manager=====");
        System.out.print("Name : ");
        name = scanner.nextLine();
        System.out.print("Age : ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.print("Phone Number : ");
        phoneNumber = scanner.nextLine();
        System.out.print("Salary : ");
        salary = Float.parseFloat(scanner.nextLine());
        System.out.print("Department : ");
        department = scanner.nextLine();
        manager = new Manager(name, age, phoneNumber, salary, department);

        System.out.println("\n\n==OFFICER DETAILS== \n");
        officer.printOfficer();
        System.out.println("\n\n==MANAGER DETAILS== \n");
        manager.printManager();
    }
}