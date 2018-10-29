
public class Item {
	
	private String name;
	private int value, weight, strengthStat, agilityStat, staminaStat, intelligenceStat;
	
	//fler kan läggas till som t.ex. rarity/color osv.
	
	
	public Item (String name, int value, int weight, int strengthStat, int agilityStat, int staminaStat, int intelligenceStat ) {
		this.name = name;
		this.value=value;
		this.weight=weight;
		this.strengthStat=strengthStat;
		this.agilityStat=agilityStat;
		this.staminaStat=staminaStat;
		this.intelligenceStat=intelligenceStat;
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

	public int getStrengthStat() {
		return strengthStat;
	}


	public int getAgilityStat() {
		return agilityStat;
	}

	public int getStaminaStat() {
		return staminaStat;
	}

	public int getIntelligenceStat() {
		return intelligenceStat;
	}


}
