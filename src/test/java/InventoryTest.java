
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public void testInventoryArraySizeIsEqualToConstant(Item[] bag) {
        assertTrue(Inventory.MAX_ITEMS_IN_BAG == bag.length);
    }

    public void testInventoryOnlyContainsItems() {
   /* Inventory inv = new Inventory();
    Item j= new Item();
        for (Item i : inv) {
            if (i != null) {
                assertTrue(i instanceof Item);
            }

        }*/
    }

    public void testMAX_ITEMS_IN_BAG_IsNotNegative() {
        assertTrue(Inventory.MAX_ITEMS_IN_BAG >= 0);
    }

    public void testPrintInventory(Item[] bag) {
        Inventory inv = new Inventory();
        Item j= new Item("a", 1, 2);
        inv.AddItemToInventory(j);
        String print = inv.printInventory(inv.getBag());
        assertTrue(print.equals("sword, bomb, gun,"));
    }

    //before this test, create an item
    public void testAddItemToInventory() {
        Inventory inv = new Inventory();
        Item j= new Item("a", 1 ,2);
        inv.AddItemToInventory(j);
        assertTrue(inv.bagContains(j));
    }

    public void testRemoveItemFromInventry() {
        Inventory inv = new Inventory();
        Item j= new Item("a", 1, 2);
        inv.removeItemFromInventory(j);
        assertTrue(!inv.bagContains(j));
    }

    public void testRemoveAllItemsFromInventry() {
        Item[] bag = new Item[Inventory.MAX_ITEMS_IN_BAG];
        for (int i = 0; i <= bag.length; i++) {
            if (bag[i] != null) {
                bag[i] = null;
            }
        }
        boolean NotEmpty = true;
        for (Item i : bag) {
            if (i != null) {
                NotEmpty = false;
                break;
            }
        }
        assertTrue(NotEmpty);

    }

    /**
     * Test of bagContains method, of class Inventory.
     */
    @Test
    public void testBagContains() {
        System.out.println("bagContains");
        Item j = null;
        Inventory instance = new Inventory();
        boolean expResult = false;
        boolean result = instance.bagContains(j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getBag method, of class Inventory.
     */
    @Test
    public void testGetBag() {
        System.out.println("getBag");
        Item j = null;
        Inventory instance = new Inventory();
        Item[] expResult = null;
        Item[] result = instance.getBag();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeItemFromInventory method, of class Inventory.
     */
    @Test
    public void testRemoveItemFromInventory() {
        System.out.println("removeItemFromInventory");
        Item j = null;
        Inventory instance = new Inventory();
        instance.removeItemFromInventory(j);
        // TODO review the generated test code and remove the default call to fail.
    }
}
//public void testInventoryNotNull(Item[] bag){
//    for (Item i: bag) {
//        AssertNotNull(i);
//}
//}

