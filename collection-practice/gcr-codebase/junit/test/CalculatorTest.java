package BridgeLabz_Training.jUnit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Addition of two numbers")
    void testAdd() {
        assertEquals(10, calculator.add(5, 5));
    }

    @Test
    @DisplayName("Subtraction of two numbers")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    @DisplayName("Multiplication of two numbers")
    void testMultiply() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    @DisplayName("Division of two numbers")
    void testDivide() {
        assertEquals(4, calculator.divide(20, 5));
    }

    @Test
    @DisplayName("Division by zero throws exception")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
