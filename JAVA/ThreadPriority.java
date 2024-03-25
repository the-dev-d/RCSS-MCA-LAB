class MyThread extends Thread {
    public void run() {
        System.out.println("Thread name: " + Thread.currentThread().getName() + ", Priority: " + Thread.currentThread().getPriority());
    }
}

class Main {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();

        // Set priorities for threads
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
