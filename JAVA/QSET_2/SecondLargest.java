import java.util.Scanner;

public class SecondLargest {

    static Integer secondLargest(Integer list[]) {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {

                if (list[j] > list[j + 1]) {

                    Integer temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

        return list[list.length - 2];
    }

    public static void main(String[] args) {

        Integer size;
        Integer elems[];
        System.out.println("How many elements : ");
        Scanner scanner = new Scanner(System.in);

        size = scanner.nextInt();
        elems = new Integer[size];
        for (int i = 0; i < size; i++) {

            System.out.print("Element " + i + ": ");
            elems[i] = scanner.nextInt();
        }
        System.out.println("Second Largest is : " + secondLargest(elems));
    }
}
