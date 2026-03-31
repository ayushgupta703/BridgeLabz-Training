
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
class NumberUtilsTest {
    @ParameterizedTest
    @ValueSource(ints={2,4,6})
    void even(int n){ assertTrue(new NumberUtils().isEven(n)); }
    @ParameterizedTest
    @ValueSource(ints={7,9})
    void odd(int n){ assertFalse(new NumberUtils().isEven(n)); }
}
