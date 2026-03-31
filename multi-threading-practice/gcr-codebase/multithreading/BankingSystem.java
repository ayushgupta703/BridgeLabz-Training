package multithreading;

class BankAccount {

    private int balance = 10000;

    // synchronized ensures only ONE thread enters at a time
    public synchronized void withdraw(int amount, String customer) {

        System.out.println(customer + " is attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(500); // simulate processing delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;

            System.out.println("Transaction successful: " + customer +
                    ", Amount: " + amount +
                    ", Remaining Balance: " + balance);
        } else {
            System.out.println("Transaction failed: " + customer +
                    ", Insufficient balance! Current Balance: " + balance);
        }
    }
}


class Transaction implements Runnable {

    private BankAccount account;
    private int amount;
    private String customer;

    public Transaction(BankAccount account, int amount, String customer) {
        this.account = account;
        this.amount = amount;
        this.customer = customer;
    }

    @Override
    public void run() {
        System.out.println("[" + Thread.currentThread().getName() +
                "] State before execution: " +
                Thread.currentThread().getState());
        account.withdraw(amount, customer);
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, 3000, "Customer-1"));
        Thread t2 = new Thread(new Transaction(account, 4000, "Customer-2"));
        Thread t3 = new Thread(new Transaction(account, 2000, "Customer-3"));
        Thread t4 = new Thread(new Transaction(account, 5000, "Customer-4"));
        Thread t5 = new Thread(new Transaction(account, 1500, "Customer-5"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

