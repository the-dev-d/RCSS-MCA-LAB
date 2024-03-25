class NumberThread extends Thread {
    static final int ODD = 1;
    static final int EVEN = 2;

    private int type;

    public NumberThread(int type) {
        this.type = type;
    }

    public void run() {
        
        for (int i = this.type; i <= 100; i += 2) {
            System.out.printf(i + " ");
        }
    }
}

class Main {
    public static void main(String[] args) {
        NumberThread oddThread = new NumberThread(NumberThread.ODD);
        NumberThread evenThread = new NumberThread(NumberThread.EVEN);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
