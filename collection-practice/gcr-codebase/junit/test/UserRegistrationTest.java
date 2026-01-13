
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class UserRegistrationTest {
    @Test void valid(){
        assertDoesNotThrow(()->new UserRegistration().registerUser("u","e","P1passw0rd"));
    }
    @Test void invalid(){
        assertThrows(IllegalArgumentException.class,
            ()->new UserRegistration().registerUser(null,"e","p"));
    }
}
