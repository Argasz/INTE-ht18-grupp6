
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

	public boolean bagContains(String itemName) {
		boolean contains = false;
		int i;
		for (i = 0; i < bag.length; i++) {
			if (bag[i] != null) {
				if (bag[i].getName().equals(itemName)) {
					contains = true;
					return contains;
				}
			}
		}
		return contains;
	}

	public Item[] getBag() {
		return bag;
	}

	public boolean addItemToInventory(Item j) {
		int i;
		for (i = 0; i < bag.length; i++) {
			if (bag[i] == null) {
				bag[i] = j;
				return true;
			}
		}
	return false;
	}

	public boolean removeItemFromInventory(String j) {
		int i;
		for (i = 0; i < bag.length; i++) {
			if (bag[i] != null) {
			if (bag[i].getName().equals(j)) {
				bag[i] = null;
				return true;
			}
			}
		}
return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < bag.length; i++) {
			if (bag[i] != null) {
				sb.append(bag[i].getName() + ", ");
			}
		}
		return sb.toString();
	}
	 public void removeAllItemsFromInventry() {
	    for (int i = 0; i < bag.length; i++) {
	            if (bag[i] != null) {
	                bag[i] = null;
	            }
	        }
	 }
}
