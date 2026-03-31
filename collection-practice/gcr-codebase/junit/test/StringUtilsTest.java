package BridgeLabz_Training.jUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class StringUtilsTest {
	private StringUtils stringUtils;
	
	@BeforeEach
	void setUp() {
		stringUtils = new StringUtils();
	}
	
	@Test
	@DisplayName("Reverse String")
	void testToReverse() {
		assertEquals("hsuya", stringUtils.toReverse("ayush"));
	}
	
	@Test
	@DisplayName("Is Palindrome")
	void testIsPalindrome() {
		assertEquals(true, stringUtils.isPalindrome("qwerewq"));
	}
	
	@Test
	@DisplayName("To Upper Case")
	void testToUpperCase() {
		assertEquals("QWEREWQ", stringUtils.toUpperCase("qwerewq"));
	}
}
