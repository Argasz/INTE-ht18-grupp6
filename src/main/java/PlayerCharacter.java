
public class PlayerCharacter extends Creature {
	private int strength, stamina;

	public PlayerCharacter(String characterName, int hp, double speed, int level) {
		super(characterName, hp, speed, level);
		this.strength = 1;
		this.stamina = 1;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getStamina(){
		return stamina;
	}
	
	public void buffStamina(){
		stamina++;
		increaseLife();
	}
	
	public void buffStrength(){
		strength++;
	}
	
	private void increaseLife(){
		setLife(getLife() + (100 * stamina)/10);
	}
	
	public void increaseLevel(){
		if(getLevel() == 10){
			return;
		}
		gainLevel();
		buffStamina();
		buffStrength();
	}
	
	public int damageDealt(){
		if(strength == 0)
			return 5;
		return 5 * strength;
	}

}
