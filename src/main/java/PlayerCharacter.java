
public class PlayerCharacter extends Creature {
	private int strength, stamina, agility, dodgeRating;

	public PlayerCharacter(String characterName, int life, int speed, int level) {
		super(characterName, life, speed, level);
		this.strength = 1;
		this.stamina = 1;
		this.agility = 1;
		this.dodgeRating = 1;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getStamina(){
		return stamina;
	}
	
	public int getAgility(){
		return agility;
	}
	
	public int getDodgeRating(){
		return dodgeRating;
	}
	
	public void buffStamina(){
		stamina++;
		increaseLife();
	}
	
	public void buffStrength(){
		strength++;
	}
	
	public void buffDodgeRating(){
		dodgeRating++;
	}
	
	private void increaseLife(){
		setLife(getLife() + (10 * stamina));
	}
	
	public void increaseLevel(){
		if(getLevel() == 10){
			return;
		}
		setLife(100);
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
