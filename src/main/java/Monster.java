
public class Monster extends Creature {

	public Monster(String characterName, int hp, int speed, int level) {
		super(characterName, hp, speed, level);
	}
	
	public int damageDealt(){
		return 10;
	}

}
