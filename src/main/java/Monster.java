
public class Monster extends Creature {

	public Monster(String characterName, int hp, int speed, int level) {
		super(characterName);
	}
	
	public int damageDealt(){
		return 10;
	}

}
