import java.util.Scanner;

class InvalidSalesAmountException extends Exception {
    public InvalidSalesAmountException(String message) {
        super(message);
    }
}

class Salesman {
    private String name;
    private int salesmanCode;
    private double salesAmount;

    public Salesman(String name, int salesmanCode, double salesAmount) throws InvalidSalesAmountException {
        if (salesAmount < 0) {
            throw new InvalidSalesAmountException("Sales amount cannot be negative.");
        }
        this.name = name;
        this.salesmanCode = salesmanCode;
        this.salesAmount = salesAmount;
    }

    public double calculateCommission() {
        if (salesAmount < 2000) {
            return salesAmount * 0.08;
        } else if (salesAmount >= 2000 && salesAmount <= 5000) {
            return salesAmount * 0.10;
        } else {
            return salesAmount * 0.12;
        }
    }

    public void displayCommission() {
        System.out.println("Salesman: " + name);
        System.out.println("Salesman Code: " + salesmanCode);
        System.out.println("Sales Amount: Rs " + salesAmount);
        System.out.println("Commission: Rs " + calculateCommission());
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Salesman Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salesman Code: ");
        int code = scanner.nextInt();

        System.out.print("Enter Sales Amount: ");
        double salesAmount = scanner.nextDouble();

        try {
            Salesman salesman = new Salesman(name, code, salesAmount);
            salesman.displayCommission();
        } catch (InvalidSalesAmountException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
