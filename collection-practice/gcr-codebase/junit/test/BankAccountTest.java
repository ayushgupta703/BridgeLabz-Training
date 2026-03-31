
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest {
    @Test void testDeposit(){
        BankAccount a=new BankAccount(); a.deposit(500);
        assertEquals(500,a.getBalance());
    }
    @Test void testWithdrawFail(){
        BankAccount a=new BankAccount();
        assertThrows(IllegalArgumentException.class,()->a.withdraw(100));
    }
}
