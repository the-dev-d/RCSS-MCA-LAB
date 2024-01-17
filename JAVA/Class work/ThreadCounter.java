import java.util.Scanner;

class DisplayThread extends Thread {
    private int m;
    private int n;

    public DisplayThread(int m, int n) {
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

        DisplayThread thread1 = new DisplayThread(a, b);
        DisplayThread thread2 = new DisplayThread(b, a);

        thread1.start();
        thread2.start();

        scanner.close();
    }
}
