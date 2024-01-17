import java.util.Scanner;

class DisplayRunnable implements Runnable {
    private int m;
    private int n;

    public DisplayRunnable(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public void run() {
        int increment = (m <= n) ? 1 : -1;

        for (int i = m; i != n + increment; i += increment) {
            System.out.println(i);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter value for 'a': ");
        int a = scanner.nextInt();

        System.out.print("Enter value for 'b': ");
        int b = scanner.nextInt();

        DisplayRunnable displayRunnable1 = new DisplayRunnable(a, b);
        DisplayRunnable displayRunnable2 = new DisplayRunnable(b, a);

        Thread thread1 = new Thread(displayRunnable1);
        Thread thread2 = new Thread(displayRunnable2);

        thread1.start();
        thread2.start();

        scanner.close();
    }
}
