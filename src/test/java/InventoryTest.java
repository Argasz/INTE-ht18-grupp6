import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vady6245
 */
public class InventoryTest {

	@Test
	public void testInventoryArraySizeIsEqualToConstant() {
		Inventory b1 = new Inventory();
		assertTrue(Inventory.MAX_ITEMS_IN_BAG == b1.getBag().length);
	}

	@Test
    public void testPrintInventory() {
		Inventory b1 = new Inventory();
		Item i1 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
		Item i2 = new Item("speedpack", 15, 5, 1, 0, 1, 1);
		Item i3 = new Item("deathpack", 15, 5, 1, 0, 1, 1);
		b1.addItemToInventory(i1);
		b1.addItemToInventory(i2);
		b1.addItemToInventory(i3);

       
        
        assertEquals("healthpack, speedpack, deathpack, ",b1.toString());
  }
	@Test
	// before this test, create an item
	public void testAddItemToInventory() {
		Inventory b1 = new Inventory();
		Item i1 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
		Item i2 = new Item("speedpack", 15, 5, 1, 0, 1, 1);
		Item i3 = new Item("deathpack", 15, 5, 1, 0, 1, 1);
		b1.addItemToInventory(i1);
		b1.addItemToInventory(i2);
		b1.addItemToInventory(i3);

		assertTrue(b1.bagContains("healthpack"));
	}
	
	@Test
	public void testAddItemToFullInventory() {
		Inventory b1 = new Inventory();
		Item i1 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
		for (int i = 0; i < 10; i++) {
			Item i2 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
				b1.addItemToInventory(i2);
		}
		assertFalse(b1.addItemToInventory(i1));
	}

	@Test
	public void testRemoveItemFromInventry() {
		Inventory b1 = new Inventory();
		Item i1 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
		Item i2 = new Item("speedpack", 15, 5, 1, 0, 1, 1);
		Item i3 = new Item("deathpack", 15, 5, 1, 0, 1, 1);
		b1.addItemToInventory(i1);
		b1.addItemToInventory(i2);
		b1.addItemToInventory(i3);

		b1.removeItemFromInventory("healthpack");
		assertTrue(!b1.bagContains("healthpack"));
	}

	@Test
	public void testRemoveAllItemsFromInventry() {

		boolean Empty = true;

		Inventory b1 = new Inventory();
		Item i1 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
		Item i2 = new Item("speedpack", 15, 5, 1, 0, 1, 1);
		Item i3 = new Item("deathpack", 15, 5, 1, 0, 1, 1);
		b1.addItemToInventory(i1);
		b1.addItemToInventory(i2);
		b1.addItemToInventory(i3);

		b1.removeAllItemsFromInventry();

		for (Item i : b1.getBag()) {
			if (i != null) {
				Empty = false;
				break;
			}
		}
		assertTrue(Empty);

	}

	/**
	 * Test of bagContains method, of class Inventory.
	 */
	@Test
	public void bagContains() {

		Inventory b1 = new Inventory();
		Item i1 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
		Item i2 = new Item("speedpack", 15, 5, 1, 0, 1, 1);
		Item i3 = new Item("deathpack", 15, 5, 1, 0, 1, 1);
		b1.addItemToInventory(i1);
		b1.addItemToInventory(i2);
		b1.addItemToInventory(i3);

		assertTrue(b1.bagContains("healthpack"));

		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getBag method, of class Inventory.
	 */
	/*
	 * @Test public void testGetBag() { System.out.println("getBag"); Item j = null;
	 * Inventory instance = new Inventory(); Item[] expResult = null; Item[] result
	 * = instance.getBag(); assertArrayEquals(expResult, result); // TODO review the
	 * generated test code and remove the default call to fail. }
	 */

	/**
	 * Test of removeItemFromInventory method, of class Inventory.
	 */
	@Test
	public void testRemoveItemFromInventory() {
		Inventory b1 = new Inventory();
		Item i1 = new Item("healthpack", 15, 5, 1, 0, 1, 1);
		Item i2 = new Item("speedpack", 15, 5, 1, 0, 1, 1);
		Item i3 = new Item("deathpack", 15, 5, 1, 0, 1, 1);
		b1.addItemToInventory(i1);
		b1.addItemToInventory(i2);
		b1.addItemToInventory(i3);
		
		b1.removeItemFromInventory("deathpack");
		assertFalse(b1.bagContains("deathpack"));	
		
	}
	@Test
	public void testRemoveItemFromEmptyInventory() {
		Inventory b1 = new Inventory();

		
		assertFalse(b1.removeItemFromInventory("deathpack"));
		
	} 
	
}
	