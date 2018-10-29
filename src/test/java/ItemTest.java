import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ItemTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetValue() {
		Item i = new Item("hej",1,10);
		
		int value = i.getValue();
		assertEquals(value,1);
	}
	
	@Test
	public void testGetWeight() {
		Item i = new Item("hej",10,1);
		
		int weight = i.getWeight();
		assertEquals(weight,1);
    }
}
