
public class PlayerCharacter extends Creature {
	private int strength, stamina, agility, intelligence;
	private int attackPower, physDef, carryWeight, magicRes, mana, evasion;
    final int BASE_AP = 2;
    final int BASE_PHYSDEF = 4;
    final int BASE_HP = 6;
    final int BASE_CARRY = 10;
    final int BASE_SPEED = 4;
    final int BASE_EVA = 4;
    final int BASE_MP = 2;
    final int BASE_MDEF = 2;

	public PlayerCharacter(String characterName, int life, int speed, int level) {
		super(characterName, life, speed, level);
		this.strength = 1;
		this.stamina = 1;
		this.agility = 1;
		this.intelligence = 1;
		calculateStats();

	}

    public int getAttackPower() {
        return attackPower;
    }

    public int getPhysDef() {
        return physDef;
    }

    public int getCarryWeight() {
        return carryWeight;
    }

    public int getMagicRes() {
        return magicRes;
    }

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if(intelligence < 1){
            throw new IllegalArgumentException("Cannot set stamina under 1.");
        }else if(intelligence > 100){
            throw new IllegalArgumentException("Cannot set stamina over 100.");
        }else{
            this.intelligence = intelligence;
        }
        calculateStats();
    }


    public int getStrength(){
		return strength;
	}

	public void setStrength(int strength) {
		if(strength < 1){
			throw new IllegalArgumentException("Cannot set strength under 1.");
		}else if(strength > 100){
			throw new IllegalArgumentException("Cannot set strength over 100.");
		}else{
			this.strength = strength;
		}

		calculateStats();
	}
	
	public int getStamina(){
		return stamina;
	}

	public void setStamina(int stamina) {
		if(stamina < 1){
			throw new IllegalArgumentException("Cannot set stamina under 1.");
		}else if(stamina > 100){
			throw new IllegalArgumentException("Cannot set stamina over 100.");
		}else{
			this.stamina = stamina;
		}
		calculateStats();
	}
	
	public int getAgility(){
		return agility;
	}

    public void setAgility(int agility) {
        if(agility < 1){
            throw new IllegalArgumentException("Cannot set agility under 1.");
        }else if(agility > 100){
            throw new IllegalArgumentException("Cannot set agility over 100.");
        }else{
            this.agility = agility;
        }
        calculateStats();
    }
	
	public int getEvasion(){
		return evasion;
	}
	
	public void buffStamina(){
		stamina++;
		increaseLife();
	}
	
	public void buffStrength(){
		strength++;
	}
	
	public void buffDodgeRating(){
		evasion++;
	}
	
	private void increaseLife(){
		setLife(getLife() + (10 * stamina));
	}
	
	public void increaseLevel(){
		if(getLevel() == 50){
			throw new IllegalStateException("Character can't go above max level!");
		}
		gainLevel();
		strength++;
		stamina++;
		agility++;
		intelligence++;
		calculateStats();
	}
	
	public int damageDealt(){
		return 5 * strength;
	}

	private void calculateStats(){
        calcApPhysDef();
        calcLifeCarry();
        calcManaMdef();
        calcSpeedEva();

    }

    private void calcLifeCarry(){
	    if(agility < 10){
	        if(stamina < 10){
	            this.setLife(stamina * BASE_HP);
	            carryWeight = stamina * BASE_CARRY;
            }else{
	            int tempLife = 9*BASE_HP;
	            tempLife += (stamina-9) * (BASE_HP * 2);
	            this.setLife(tempLife);
	            carryWeight = 9*BASE_CARRY;
	            carryWeight += (stamina-9) * (BASE_CARRY * 2);
            }
        }else{
	        if(stamina < 10){
	            setLife(stamina * (BASE_HP/2));
	            carryWeight = stamina * (BASE_CARRY/2);
            }else{
	            this.setLife(stamina * BASE_HP);
	            carryWeight = stamina*BASE_CARRY;
            }
        }
    }

    private void calcApPhysDef(){
	    if(intelligence < 10){
	        if(strength < 10){
                attackPower = strength*BASE_AP;
                physDef = strength*BASE_PHYSDEF;
            }else{
	            attackPower = 9*BASE_AP;
	            attackPower += (strength-9)*(BASE_AP * 2);
	            physDef = 9*BASE_PHYSDEF;
	            physDef += (strength - 9) * (BASE_PHYSDEF * 2);
            }
        }else{
	        if(strength < 10){
	            attackPower = strength;
	            physDef = strength * (BASE_PHYSDEF/2);
            }else{
	            attackPower = strength*BASE_AP;
	            physDef = strength*BASE_PHYSDEF;
            }
        }
    }

	private void calcSpeedEva(){
		if(stamina < 10){
			if(agility < 10){
				evasion = agility*BASE_EVA;
				setSpeed( agility*BASE_SPEED);
			}else{
				evasion = 9*BASE_EVA;
				evasion += (agility-9)*(BASE_EVA * 2);
				int newSpeed = 9*BASE_SPEED + (agility-9) * (BASE_SPEED * 2);
				setSpeed(newSpeed);
			}
		}else{
			if(agility < 10){
				evasion = agility * (BASE_EVA/2);
				setSpeed(agility * (BASE_PHYSDEF/2));
			}else{
				evasion = agility*BASE_EVA;
				setSpeed(agility*BASE_SPEED);
			}
		}
	}

	private void calcManaMdef(){
		if(strength < 10){
			if(intelligence < 10){
				mana = intelligence*BASE_MP;
				magicRes = intelligence*BASE_MDEF;
			}else{
				mana = 9*BASE_MP;
				mana += (intelligence-9)*(BASE_MP * 2);
				magicRes = 9*BASE_MDEF + (intelligence-9) * (BASE_MDEF * 2);
			}
		}else{
			if(intelligence < 10){
				mana = intelligence * (BASE_MP/2);
				magicRes = intelligence * (BASE_MDEF/2);
			}else{
				mana = intelligence*BASE_MP;
				magicRes = intelligence*BASE_MDEF;
			}
		}
	}

}
