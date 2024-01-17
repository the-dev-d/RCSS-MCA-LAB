import java.util.InputMismatchException;
import java.util.Scanner;

class IllegalName extends Exception {
    public IllegalName(String message) {
        super(message);
    }
}

class IllegalAge extends Exception {
    public IllegalAge(String message) {
        super(message);
    }
}

class Person {
    String name;
    int age;

    private void validateName(String name) throws IllegalName {
        if (!name.matches("^[a-zA-Z.\\s]+$")) {
            throw new IllegalName("Name should contain only alphabets, spaces, or periods.");
        }
    }

    private void validateAge(int age) throws IllegalAge {
        if (age < 0) {
            throw new IllegalAge("Age cannot be negative.");
        }
    }

    public void setName(String name) throws IllegalName {
        validateName(name);
        this.name = name;
    }

    public void setAge(int age) throws IllegalAge {
        validateAge(age);
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();

        try {
            System.out.print("Enter person's name: ");
            String name = scanner.nextLine();
            person.setName(name);

            System.out.print("Enter person's age: ");
            int age = scanner.nextInt();
            person.setAge(age);

            System.out.println("Person created: " + person.name + ", " + person.age + " years old.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid age.");
        } catch (IllegalName e) {
            System.out.println("Invalid name: " + e.getMessage());
        } catch (IllegalAge e) {
            System.out.println("Invalid age: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
