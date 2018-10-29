import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ItemTest {

	@Test
	public void testGetValue() {
		Item i = new Item("hej",1,10,1,1,1,1);
		
		int value = i.getValue();
		assertEquals(value,1);
	}
	
	@Test
	public void testGetWeight() {
		Item i = new Item("hej",10,1,1,1,1,1);
		
		int weight = i.getWeight();
		assertEquals(weight,1);
    }
	
	@Test
	public void testStrengthStat() {
		Item i = new Item("healthpack", 15,5,0,1,1,1);
		assertEquals(i.getStrengthStat(),0);
	}
	@Test
	public void testAgilityStat() {
		Item i = new Item("healthpack", 15,5,1,0,1,1);
		assertEquals(i.getAgilityStat(),0);
	}
	@Test
	public void testStaminaStat() {
		Item i = new Item("healthpack", 15,5,1,1,0,1);
		assertEquals(i.getStaminaStat(),0);
	}
	@Test
	public void testIntelligenceStat() {
		Item i = new Item("healthpack", 15,5,1,1,1,0);
		assertEquals(i.getIntelligenceStat(),0);
	}
	
}
