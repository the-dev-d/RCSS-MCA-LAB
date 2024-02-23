import java.util.Random;

class SharedData {
    public int data;
}

class RandomNumberGenerator extends Thread {
    private Random random;
    private SharedData sharedData;

    public RandomNumberGenerator(SharedData sharedData) {
        this.sharedData = sharedData;
        random = new Random();
    }

    public void run() {
        synchronized (this.sharedData) {
            try {
                while (true) {
                    sharedData.data = random.nextInt(100);
                    System.out.println("Random number is " + sharedData.data);
                    this.sharedData.notifyAll();
                    this.sharedData.wait(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenSquare extends Thread {
    SharedData sharedData;

    EvenSquare(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        synchronized (this.sharedData) {
            try {
                while (true) {
                    this.sharedData.wait(1000);
                    if (sharedData.data % 2 == 0) {
                        System.out.println("Square is : " + sharedData.data * sharedData.data);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class OddCube extends Thread {
    SharedData sharedData;

    OddCube(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void run() {
        synchronized (this.sharedData) {
            try {
                while (true) {
                    this.sharedData.wait();
                    if (sharedData.data % 2 != 0) {
                        System.out.println("Cube is : " + sharedData.data * sharedData.data * sharedData.data);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class TriThreadCalculation {
    public static void main(String args[]) throws Exception {
        SharedData sharedData = new SharedData();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(sharedData);
        EvenSquare evenSquare = new EvenSquare(sharedData);
        OddCube oddCube = new OddCube(sharedData);

        oddCube.start();
        evenSquare.start();
        randomNumberGenerator.start();

    }
}
