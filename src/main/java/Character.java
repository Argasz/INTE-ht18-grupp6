public class Character {
	 
	// Sätter upp eclipse med Github - TEST
	
    private int life;
    private float speed;
    private int level;
    private String characterName;
	
	public Character(String characterName, int hp, float speed, int level){
		this.characterName = characterName;
		this.life = hp;
		this.speed = speed;
		this.level = level;
	}
        

    public int getLife(){
    	return life;}

	public float getSpeed(){
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

        

}
