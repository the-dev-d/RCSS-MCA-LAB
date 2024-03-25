import java.util.Scanner;

class Staff {
    String code;
    String name;

    // Constructor
    public Staff(String code, String name) {
        this.code = code;
        this.name = name;
    }
}

class Faculty extends Staff {
    String department;
    String subjectTaken;
    String researchArea;

    // Constructor
    public Faculty(String code, String name, String department, String subjectTaken, String researchArea) {
        super(code, name);
        this.department = department;
        this.subjectTaken = subjectTaken;
        this.researchArea = researchArea;
    }
}

class Typist extends Staff {
    String office;
    int speed;

    // Constructor
    public Typist(String code, String name, String office, int speed) {
        super(code, name);
        this.office = office;
        this.speed = speed;
    }
}

class Officer extends Staff {
    String rank;
    String grade;

    // Constructor
    public Officer(String code, String name, String rank, String grade) {
        super(code, name);
        this.rank = rank;
        this.grade = grade;
    }
}

class Permanent extends Typist {
    double salary;

    // Constructor
    public Permanent(String code, String name, String office, int speed, double salary) {
        super(code, name, office, speed);
        this.salary = salary;
    }
}

class Casual extends Typist {
    double dailyWage;

    // Constructor
    public Casual(String code, String name, String office, int speed, double dailyWage) {
        super(code, name, office, speed);
        this.dailyWage = dailyWage;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for a faculty member
        System.out.println("Enter details for Faculty:");
        System.out.print("Code: ");
        String facultyCode = scanner.next();
        System.out.print("Name: ");
        String facultyName = scanner.next();
        System.out.print("Department: ");
        String department = scanner.next();
        System.out.print("Subject Taken: ");
        String subjectTaken = scanner.next();
        System.out.print("Research Area: ");
        String researchArea = scanner.next();

        Faculty faculty = new Faculty(facultyCode, facultyName, department, subjectTaken, researchArea);

        // Taking input for a permanent typist
        System.out.println("\nEnter details for Permanent Typist:");
        System.out.print("Code: ");
        String permTypistCode = scanner.next();
        System.out.print("Name: ");
        String permTypistName = scanner.next();
        System.out.print("Office: ");
        String office = scanner.next();
        System.out.print("Speed: ");
        int speed = scanner.nextInt();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        Permanent permTypist = new Permanent(permTypistCode, permTypistName, office, speed, salary);

        // Displaying details
        System.out.println("\nFaculty Details:");
        System.out.println("Code: " + faculty.code);
        System.out.println("Name: " + faculty.name);
        System.out.println("Department: " + faculty.department);
        System.out.println("Subject Taken: " + faculty.subjectTaken);
        System.out.println("Research Area: " + faculty.researchArea);

        System.out.println("\nPermanent Typist Details:");
        System.out.println("Code: " + permTypist.code);
        System.out.println("Name: " + permTypist.name);
        System.out.println("Office: " + permTypist.office);
        System.out.println("Speed: " + permTypist.speed);
        System.out.println("Salary: " + permTypist.salary);

        scanner.close();
    }
}
