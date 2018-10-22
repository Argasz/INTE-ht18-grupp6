
public class Item {
	
	private String name;
	private int value;
	private int weight;
	//fler kan läggas till som t.ex. rarity/color osv.
	
	
	public Item (String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getWeight() {
		return weight;
	}

}
