import java.util.Scanner;

class SearchThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int key;

    public SearchThread(int[] array, int start, int end, int key) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.key = key;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (array[i] == key) {
                System.out.println("Key found at index " + i);
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the key element to be searched: ");
        int key = scanner.nextInt();

        int chunkSize = 5;
        int threadsCount = (int) Math.ceil((double) n / chunkSize);
        Thread[] threads = new Thread[threadsCount];

        for (int i = 0; i < threadsCount; i++) {
            int start = i * chunkSize;
            int end = Math.min((i + 1) * chunkSize - 1, n - 1);
            threads[i] = new SearchThread(array, start, end, key);
            threads[i].start();
        }

        scanner.close();
    }
}
