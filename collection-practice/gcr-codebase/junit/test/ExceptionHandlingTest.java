package BridgeLabz_Training.jUnit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTest {
	private ExceptionHandling exceptionHandling;
	
	@BeforeEach
	void setUp() {
		exceptionHandling = new ExceptionHandling();
	}
	
	@Test
	@DisplayName("Divide By Zero Exception")
	void testDivide() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, ()->exceptionHandling.divide(10, 0));
		assertEquals("Division By Zero Not Allowed", exception.getMessage());
		assertEquals(5, exceptionHandling.divide(10, 2));
	}
}
