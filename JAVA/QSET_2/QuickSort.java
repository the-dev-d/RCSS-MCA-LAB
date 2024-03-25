import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuickSort {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of names:");
        int numNames = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Enter the names:");
        for (int i = 0; i < numNames; i++) {
            names.add(scanner.nextLine());
        }

        System.out.println("Original list of names:");
        System.out.println(names);

        quickSort(names, 0, names.size() - 1);

        System.out.println("\nSorted list of names:");
        System.out.println(names);

        scanner.close();
    }

    public static void quickSort(List<String> names, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(names, low, high);
            quickSort(names, low, pivotIndex - 1);
            quickSort(names, pivotIndex + 1, high);
        }
    }

    public static int partition(List<String> names, int low, int high) {
        String pivot = names.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (names.get(j).compareTo(pivot) < 0) {
                i++;
                swap(names, i, j);
            }
        }
        swap(names, i + 1, high);
        return i + 1;
    }

    public static void swap(List<String> names, int i, int j) {
        String temp = names.get(i);
        names.set(i, names.get(j));
        names.set(j, temp);
    }
}
