class PriorityThread extends Thread {

    private int n;

    PriorityThread(int n, int priority) {
        super();
        this.n = n;
        this.setPriority(priority);
    }

    public void run() {
        for (int i = 0; i < this.n; i++) {
            System.out.println("Iteration " + i + " of " + this.getPriority() + " priority thread");
        }
    }

}

class Main {

    public static void main(String args[]) throws Exception {

        PriorityThread p1 = new PriorityThread(10, Thread.MIN_PRIORITY);
        PriorityThread p2 = new PriorityThread(30, Thread.MAX_PRIORITY);

        p1.start();
        p2.start();
    }
}
