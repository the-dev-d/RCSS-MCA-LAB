import java.util.Scanner;

interface Wishable {
    String getName();
}

class Wishings {
    void wish(Wishable wishable) {
        System.out.println("Hello " + wishable.getName());
    }
}

class Person implements Wishable {
    String name;

    public String getName() {
        return name;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Person person = new Person();
        System.out.print("Enter person name: ");
        person.name = scanner.nextLine();

        Wishings wishings = new Wishings();
        wishings.wish(person);

        scanner.close();
    }
}
