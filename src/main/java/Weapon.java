
public class Weapon extends Item {
	
	private int damage;
	
	public Weapon (String name, int value, int weight, int damage) {
		super(name, value, weight);
		this.damage = damage;
		
	}
	
	public int getDamage() {
		return damage;
	}

}
