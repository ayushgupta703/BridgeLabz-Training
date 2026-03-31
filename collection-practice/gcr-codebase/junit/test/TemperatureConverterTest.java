
package BridgeLabz_Training.jUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TemperatureConverterTest {
    @Test void cToF(){ assertEquals(32,new TemperatureConverter().celsiusToFahrenheit(0)); }
    @Test void fToC(){ assertEquals(0,new TemperatureConverter().fahrenheitToCelsius(32)); }
}
