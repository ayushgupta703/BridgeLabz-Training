package BridgeLabz_Training.jUnit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
	private ListManager listManager;
	private List<Integer> list;
	
	@BeforeEach
	void setUp() {
		listManager = new ListManager();
		list = new ArrayList<Integer>();
	}
	
	@Test
	@DisplayName("Add Elements To List")
	void testAddElement() {
		listManager.addElement(list, 10);
		listManager.addElement(list, 20);
		assertTrue(list.contains(10));
		assertTrue(list.contains(20));
	}
	
	@Test
	@DisplayName("Remove Element From List")
	void testRemoveElement() {
		listManager.removeElement(list, 20);
		assertFalse(list.contains(20));
	}
	
	@Test
	@DisplayName("Get Size Of List")
	void testGetSize() {
		assertEquals(0, listManager.getSize(list));
	}
}
