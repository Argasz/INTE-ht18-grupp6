public class Character {
	 
	// Sätter upp eclipse med Github - TEST
	
    private int life;
    private float speed;
    private int level;
	
	public Character(int hp, float speed){
		this.life = hp;
		this.speed = speed;
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
		level++;
	}

        

}
