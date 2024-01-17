import java.util.Scanner;

class Keyboard {
    int noOfKeys;
    boolean backlight;

    void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of keys: ");
        noOfKeys = scanner.nextInt();
        System.out.print("Does the keyboard have backlight? (true/false): ");
        backlight = scanner.nextBoolean();
    }

    void display() {
        System.out.println("Number of Keys: " + noOfKeys);
        System.out.println("Backlight: " + backlight);
    }
}

class MechanicalKeyboard extends Keyboard {
    String switchType;

    void read() {
        super.read();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the switch type for the mechanical keyboard: ");
        switchType = scanner.next();
    }

    void display() {
        super.display();
        System.out.println("Switch Type: " + switchType);
    }
}

class Main {
    public static void main(String[] args) {
        Keyboard standardKeyboard = new Keyboard();
        System.out.println("Enter details for Standard Keyboard:");
        standardKeyboard.read();
        System.out.println("\nDetails for Standard Keyboard:");
        standardKeyboard.display();

        MechanicalKeyboard mechanicalKeyboard = new MechanicalKeyboard();
        System.out.println("\nEnter details for Mechanical Keyboard:");
        mechanicalKeyboard.read();
        System.out.println("\nDetails for Mechanical Keyboard:");
        mechanicalKeyboard.display();
    }
}
