class MyRunnable implements Runnable {
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started.");
            Thread.sleep(500); // Suspend the thread for 500 milliseconds
            System.out.println(Thread.currentThread().getName() + " finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Create Runnable instances
        Runnable r1 = new MyRunnable();
        Runnable r2 = new MyRunnable();
        Runnable r3 = new MyRunnable();

        // Create threads using Runnable instances
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);
        Thread thread3 = new Thread(r3);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish execution
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread exiting.");
    }
}
