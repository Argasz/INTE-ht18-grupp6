public abstract class Creature {
	 
	// Sätter upp eclipse med Github - TEST
	
    private int life, level;
    private double speed;
    private final String characterName;
	
	public Creature(String characterName, int hp, double speed, int level){
		if(characterName.length() == 0){
			throw new IllegalArgumentException("Illegal argument: name has to be at least 1 character long");
		} else if (characterName.length() > 20) {
			throw new IllegalArgumentException("Illegal argument: name too long, max 20 characters");
		}
		this.characterName = characterName;
		this.life = hp;
		this.speed = speed;
		this.level = level;
	}
	
	public abstract int damageDealt();
	
	public String getName(){
		return characterName;
	}

    public int getLife(){
    	return life;}

	public double getSpeed(){
		return speed;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void gainLevel(){
		if(level == 10)
			return;
		level++;
	}
	
	public void setLife(int newLife){
		this.life = newLife;
	}
	
	public void damageTaken(int damage){
		if(life <= 0){
			throw new IllegalStateException("Creature is already dead, can't have less than 0 life");
		}
		life = life - damage;
	}

}
