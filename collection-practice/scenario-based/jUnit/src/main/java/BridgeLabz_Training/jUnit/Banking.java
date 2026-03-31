
package BridgeLabz_Training.jUnit;
public class Banking {
    private double balance;
    public void deposit(double a){
    	if(a < 0) {
    		throw new IllegalArgumentException("Deposit Amount Cannot Be Negative");
    	} else {
    		balance += a;
    	}
    }
    public void withdraw(double a){
        if(a > balance) {
        	throw new IllegalArgumentException("Insufficient funds");
        } else {
        	balance-=a;
        }
    }
    public double getBalance(){
    	return balance;
    }
}
