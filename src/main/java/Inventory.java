/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vady6245
 */
public class Inventory {
    
    public static final int MAX_ITEMS_IN_BAG = 10;
     private Item[] bag;

    public Inventory() {
        bag = new Item[Inventory.MAX_ITEMS_IN_BAG];
    }
    public boolean bagContains(Item j) {
        boolean contains = false;
        return contains;
    }
    
    public Item[] getBag() {
        return bag;
    }

public void AddItemToInventory(Item j) {
        int i;
        for (i = 0; i <= bag.length; i++) {
            if (bag[i] == null) {
                bag[i] = j;
                return;
            }
        }
    }
public void removeItemFromInventory(Item j) {
        int i;
        Item[] bag = new Item[Inventory.MAX_ITEMS_IN_BAG];
        for (i = 0; i <= MAX_ITEMS_IN_BAG; i++) {
            if (bag[i] == null)
            
            
                }   
      
}

public String printInventory(Item[] bag) {
        String content = "";
        for (Item i : bag) {
            if (i != null) {
                content += (i.toString + ", ");
            }
        }
return content;
}
}

  