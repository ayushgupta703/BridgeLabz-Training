
package BridgeLabz_Training.jUnit;
public class BankAccount {
    private double balance;
    public void deposit(double a){ balance+=a; }
    public void withdraw(double a){
        if(a>balance) throw new IllegalArgumentException("Insufficient funds");
        balance-=a;
    }
    public double getBalance(){ return balance; }
}
