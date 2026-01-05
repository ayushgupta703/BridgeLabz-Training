package reviews;
import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
abstract class Account {
    protected int accountNumber;
    protected String holderName;
    protected double balance;
    protected LinkedList<String> transactions = new LinkedList<>();

    public Account(int accNo, String name, double bal) {
        accountNumber = accNo;
        holderName = name;
        balance = bal;
        transactions.add("Account opened with ₹" + bal);
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited ₹" + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException("❌ Insufficient Balance");
        balance -= amount;
        transactions.add("Withdrawn ₹" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println("Transaction History:");
        for (String t : transactions)
            System.out.println("- " + t);
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends Account {
    public SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    public double calculateInterest() {
        return 0;
    }
}

interface BankService {
    void createAccount(Account acc);
    void deposit(int accNo, double amt);
    void withdraw(int accNo, double amt);
    void transfer(int from, int to, double amt);
    void showBalance(int accNo);
    void showTransactions(int accNo);
}

class Bank implements BankService {
    private HashMap<Integer, Account> accounts = new HashMap<>();

    public void createAccount(Account acc) {
        accounts.put(acc.accountNumber, acc);
        System.out.println("Account Created Successfully");
    }

    public void deposit(int accNo, double amt) {
        accounts.get(accNo).deposit(amt);
        System.out.println("Deposit Successful");
    }

    public void withdraw(int accNo, double amt) {
        try {
            accounts.get(accNo).withdraw(amt);
            System.out.println("Withdrawal Successful");
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void transfer(int from, int to, double amt) {
        Account sender = accounts.get(from);
        Account receiver = accounts.get(to);

        synchronized (sender) {
            synchronized (receiver) {
                try {
                    sender.withdraw(amt);
                    receiver.deposit(amt);
                    sender.transactions.add("Transferred ₹" + amt + " to " + to);
                    receiver.transactions.add("Received ₹" + amt + " from " + from);
                    System.out.println("Transfer Successful");
                } catch (InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void showBalance(int accNo) {
        System.out.println("Balance: ₹" + accounts.get(accNo).getBalance());
    }

    public void showTransactions(int accNo) {
        accounts.get(accNo).showTransactions();
    }
}

class TransferThread extends Thread {
    Bank bank;
    int from, to;
    double amount;

    TransferThread(Bank bank, int from, int to, double amt) {
        this.bank = bank;
        this.from = from;
        this.to = to;
        this.amount = amt;
    }

    public void run() {
        bank.transfer(from, to, amount);
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n====== ONLINE BANKING MENU ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    System.out.print("1.Savings  2.Current: ");
                    int type = sc.nextInt();

                    if (type == 1)
                        bank.createAccount(new SavingsAccount(accNo, name, bal));
                    else
                        bank.createAccount(new CurrentAccount(accNo, name, bal));
                    break;

                case 2:
                    System.out.print("Account No: ");
                    bank.deposit(sc.nextInt(), sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Account No: ");
                    bank.withdraw(sc.nextInt(), sc.nextDouble());
                    break;

                case 4:
                    System.out.print("From Acc: ");
                    int from = sc.nextInt();
                    System.out.print("To Acc: ");
                    int to = sc.nextInt();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();

                    Thread t1 = new TransferThread(bank, from, to, amt);
                    t1.start();
                    break;

                case 5:
                    System.out.print("Account No: ");
                    bank.showBalance(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Account No: ");
                    bank.showTransactions(sc.nextInt());
                    break;

                case 7:
                    System.out.println("Thank You! Banking Closed.");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
