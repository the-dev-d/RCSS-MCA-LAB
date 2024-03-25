import java.util.LinkedList;
import java.util.Scanner;

public class DoublyLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert at First");
            System.out.println("2. Insert at Last");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at first: ");
                    int firstElement = scanner.nextInt();
                    list.addFirst(firstElement);
                    System.out.println("Element inserted at first.");
                    break;
                case 2:
                    System.out.print("Enter element to insert at last: ");
                    int lastElement = scanner.nextInt();
                    list.addLast(lastElement);
                    System.out.println("Element inserted at last.");
                    break;
                case 3:
                    if (list.isEmpty()) {
                        System.out.println("List is empty. Nothing to remove.");
                    } else {
                        int removedFirst = list.removeFirst();
                        System.out.println("Removed element from the first position: " + removedFirst);
                    }
                    break;
                case 4:
                    if (list.isEmpty()) {
                        System.out.println("List is empty. Nothing to remove.");
                    } else {
                        int removedLast = list.removeLast();
                        System.out.println("Removed element from the last position: " + removedLast);
                    }
                    break;
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        System.out.println("Elements in the list:");
                        System.out.println(list);
                    }
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
