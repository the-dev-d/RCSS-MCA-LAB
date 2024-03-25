import java.util.Scanner;

class Time {
    private int hours;
    private int minutes;

    // Constructors
    public Time() {
        hours = 0;
        minutes = 0;
    }

    public Time(int h, int m) {
        hours = h;
        minutes = m;
    }

    // Member function to sum two Time objects
    public Time sum(Time t) {
        Time result = new Time();
        result.minutes = minutes + t.minutes;
        result.hours = hours + t.hours + (result.minutes / 60);
        result.minutes %= 60;
        result.hours %= 24; // Ensure hours don't exceed 24
        return result;
    }

    // Display time in "hh:mm" format
    public void display() {
        System.out.println("Time: " + hours + ":" + minutes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h, m;

        // Getting user inputs for hours and minutes for Time object 1
        System.out.print("Enter hours for Time 1: ");
        h = scanner.nextInt();
        System.out.print("Enter minutes for Time 1: ");
        m = scanner.nextInt();
        Time t1 = new Time(h, m);

        // Getting user inputs for hours and minutes for Time 2
        System.out.print("Enter hours for Time 2: ");
        h = scanner.nextInt();
        System.out.print("Enter minutes for Time 2: ");
        m = scanner.nextInt();
        Time t2 = new Time(h, m);

        // Sum of t1 and t2 stored in t3
        Time t3 = t1.sum(t2);

        // Displaying all times
        System.out.print("Time 1:");
        t1.display();
        System.out.print("Time 2:");
        t2.display();
        System.out.print("Time Added :");
        t3.display();

        scanner.close();
    }
}
