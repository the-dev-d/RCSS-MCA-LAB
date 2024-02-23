class ThreadCounter extends Thread {

    public static int EVEN = 0;
    public static int ODD = 1;

    private int start;

    ThreadCounter(int start) {
        super();
        this.start = start;
    }

    public void run() {
        for (int i = start; i <= 100; i += 2) {
            System.out.println(i);
        }
    }

}

class Main {

    public static void main(String args[]) throws Exception {

        ThreadCounter odd = new ThreadCounter(ThreadCounter.ODD);
        ThreadCounter even = new ThreadCounter(ThreadCounter.EVEN);

        odd.start();
        even.start();

        odd.join();
        even.join();

    }
}
