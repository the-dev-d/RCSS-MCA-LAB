class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient funds.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

class DepositThread1 extends Thread {
    private Account account;

    public DepositThread1(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
        }
    }
}

class DepositThread2 extends Thread {
    private Account account;

    public DepositThread2(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(150);
        }
    }
}

class WithdrawThread extends Thread {
    private Account account;

    public WithdrawThread(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            account.withdraw(100);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Account account = new Account(1000);

        DepositThread1 depositThread1 = new DepositThread1(account);
        DepositThread2 depositThread2 = new DepositThread2(account);
        WithdrawThread withdrawThread = new WithdrawThread(account);

        // Start threads
        depositThread1.start();
        depositThread2.start();
        withdrawThread.start();

        // Wait for threads to finish
        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
