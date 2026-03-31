
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class PasswordValidatorTest {
    @Test void valid(){ assertTrue(new PasswordValidator().isValid("Strong1Pass")); }
    @Test void invalid(){ assertFalse(new PasswordValidator().isValid("weak")); }
}
