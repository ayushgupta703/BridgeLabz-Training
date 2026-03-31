
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankingTest {
    @Test
    public void Test_Deposit_ValidAmount(){
        Banking a=new Banking();
        a.deposit(500);
        assertEquals(500,a.getBalance());
    }
    
    @Test
    public void Test_Deposit_NegativeAmount(){
        Banking a=new Banking();
        assertThrows(IllegalArgumentException.class, ()->a.deposit(-500));
    }
    
    @Test
    public void Test_Withdraw_ValidAmount(){
        Banking a=new Banking();
        a.deposit(500);
        a.withdraw(400);
        assertEquals(100,a.getBalance());
    }
    
    @Test
    public void Test_Withdraw_InsufficientFunds(){
        Banking a=new Banking();
        assertThrows(IllegalArgumentException.class,()->a.withdraw(100));
    }
}
