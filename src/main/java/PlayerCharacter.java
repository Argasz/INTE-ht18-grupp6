
public class PlayerCharacter extends Creature {
	private int strength, stamina;

	public PlayerCharacter(String characterName, int hp, double speed, int level) {
		super(characterName, hp, speed, level);
	}
	
	private void buffStamina(){
		
	}
	
	private void buffStrength(){
		
	}
	
	public int damageDealt(){
		return 10;
	}

}
