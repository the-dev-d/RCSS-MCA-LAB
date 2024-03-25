import java.util.Scanner;

class Account {
    private String accountHolderName;
    private int accountNumber;
    private String address;
    private String accountType;
    private double balance;

    // Static constants for account types
    public static final String CURRENT = "Current";
    public static final String SAVINGS = "Savings";

    // First constructor
    public Account(String name, int accNumber, double initialAmount) {
        accountHolderName = name;
        accountNumber = accNumber;
        balance = initialAmount;
    }

    // Second constructor
    public Account(String name, int accNumber, String addr, String type, double currentBalance) {
        accountHolderName = name;
        accountNumber = accNumber;
        address = addr;
        accountType = type;
        balance = currentBalance;
    }

    // Method to deposit amount
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }

    // Method to withdraw amount
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to get current balance
    public double getBalance() {
        return balance;
    }

    // Method to print account details
    public void printDetails() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Address: " + address);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: $" + getBalance());
    }

    public static void main(String[] args) {
        // Creating account objects using the first constructor
        Account account1 = new Account("Dhaivath", 123456, 1000.0);

        // Performing deposit and withdraw operations
        account1.deposit(500.0); // Deposit $500
        account1.withdraw(200.0); // Withdraw $200

        // Printing account details
        account1.printDetails();
        System.out.println();

        // Creating account objects using the second constructor
        Account account2 = new Account("Lal", 654321, "123 NY", Account.SAVINGS, 5000.0);

        // Performing deposit and withdraw operations
        account2.deposit(1000.0); // Deposit $1000
        account2.withdraw(7000.0); // Attempt to withdraw more than balance

        // Printing account details
        account2.printDetails();
    }
}