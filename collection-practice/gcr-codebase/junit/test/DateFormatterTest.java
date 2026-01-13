
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DateFormatterTest {
    @Test void valid(){
        assertEquals("15-08-2024",new DateFormatter().formatDate("2024-08-15"));
    }
    @Test void invalid(){
        assertThrows(Exception.class,()->new DateFormatter().formatDate("15/08/2024"));
    }
}
