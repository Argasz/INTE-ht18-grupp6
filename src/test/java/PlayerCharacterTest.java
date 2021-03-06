import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class PlayerCharacterTest {
    final int BASE_AP = 2;
    final int BASE_PHYSDEF = 4;
    final int BASE_HP = 6;
    final int BASE_CARRY = 10;
    final int BASE_SPEED = 4;
    final int BASE_EVA = 4;
    final int BASE_MP = 2;
    final int BASE_MDEF = 2;

    @Test
    public void testSetValidStrength(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStrength(10);
        assertEquals(10,p.getStrength());
    }
    @Test
    public void testSetValidStamina(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStamina(10);
        assertEquals(10,p.getStamina());
    }

    @Test
    public void testSetValidAgility(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setAgility(10);
        assertEquals(10,p.getAgility());
    }

    @Test
    public void testSetValidIntelligence(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setIntelligence(10);
        assertEquals(10,p.getIntelligence());
    }

    @Test
    public void testSetStrengthUnder1(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setStrength(0);
        });
    }

    @Test
    public void testSetStrengthOverMax(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setStrength(101);
        });
    }

    @Test
    public void testStrengthBaseGrowth1(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStrength(9);
        p.setIntelligence(9);
        assertEquals(BASE_AP * 9, p.getAttackPower());
        assertEquals(BASE_PHYSDEF * 9, p.getPhysDef());
    }

    @Test
    public void testStrengthBaseGrowth2(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStrength(11);
        p.setIntelligence(11);
        assertEquals(BASE_AP * 11, p.getAttackPower());
        assertEquals(BASE_PHYSDEF * 11, p.getPhysDef());
    }

    @Test
    public void testStrengthMinGrowth(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStrength(9);
        p.setIntelligence(11);
        assertEquals( 9, p.getAttackPower());
        int expectedPhysdef = 9*(BASE_PHYSDEF/2);
        assertEquals( expectedPhysdef, p.getPhysDef());
    }

    @Test
    public void testStrengthMaxGrowth(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStrength(12);
        p.setIntelligence(9);
        int expectedAP = BASE_AP*9 + ((BASE_AP * 2) * (12-9));
        int expectedPdef = BASE_PHYSDEF*9 + ((BASE_PHYSDEF * 2) * (12-9));
        assertEquals(expectedAP, p.getAttackPower());
        assertEquals(expectedPdef, p.getPhysDef());
    }

    @Test
    public void testSetStaminaUnder1(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setStamina(0);
        });
    }

    @Test
    public void testSetStaminaOverMax(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setStamina(101);
        });
    }

    @Test
    public void testStaminaBaseGrowth1(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStamina(9);
        assertEquals(BASE_HP * 9, p.getLife());
        assertEquals(BASE_CARRY * 9, p.getCarryWeight());
    }

    @Test
    public void testStaminaBaseGrowth2(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStamina(11);
        p.setAgility(11);
        assertEquals(BASE_HP * 11, p.getLife());
        assertEquals(BASE_CARRY * 11, p.getCarryWeight());
    }

    @Test
    public void testStaminaMinGrowth(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStamina(9);
        p.setAgility(11);
        int expectedLife= 9*(BASE_HP/2);
        assertEquals( expectedLife, p.getLife());
        int expectedCarry = 9*(BASE_CARRY/2);
        assertEquals( expectedCarry, p.getCarryWeight());
    }

    @Test
    public void testStaminaMaxGrowth(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStamina(12);
        int expectedLife = BASE_HP*9 + ((BASE_HP * 2) * (12-9));
        int expectedCarry = BASE_CARRY*9 + ((BASE_CARRY * 2) * (12-9));
        assertEquals(expectedLife, p.getLife());
        assertEquals(expectedCarry, p.getCarryWeight());
    }

    @Test
    public void testSetAgilityUnder1(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setAgility(0);
        });
    }

    @Test
    public void testSetAgilityOverMax(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setAgility(101);
        });
    }
    
    @Test
	public void testPlayerStatsAfterLvlUp(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		 
		player.increaseLevel();
		assertEquals(2, player.getLevel());
		assertEquals(2, player.getStamina());
		assertEquals(2, player.getStrength());
		assertEquals(2, player.getAgility());
		assertEquals(2, player.getIntelligence());
		assertEquals(12, player.getLife());
		    
		assertEquals(2*BASE_AP, player.getAttackPower());
		assertEquals(2*BASE_PHYSDEF, player.getPhysDef());
		assertEquals(2*BASE_CARRY, player.getCarryWeight());
		assertEquals(2*BASE_EVA, player.getEvasion());
		assertEquals(2*BASE_MP, player.getMana());
		assertEquals(2*BASE_MDEF, player.getMagicDef());
		
		player.increaseLevel();
		player.increaseLevel();
		
		assertEquals(4*BASE_AP, player.getAttackPower());
		assertEquals(4*BASE_PHYSDEF, player.getPhysDef());
		assertEquals(4*BASE_CARRY, player.getCarryWeight());
		assertEquals(4*BASE_EVA, player.getEvasion());
		assertEquals(4*BASE_MP, player.getMana());
		assertEquals(4*BASE_MDEF, player.getMagicDef());
	}
    
    @Test
    public void testInvalidAboveMaxLevel(){
    	PlayerCharacter player = new PlayerCharacter("JohnDoe");

        for (int i = 1; i < 50; i++) {
            player.increaseLevel();
        }

    	assertThrows(IllegalStateException.class, () -> {
			player.increaseLevel();
		});
    }

    @Test
    public void testAgilityBaseGrowth1(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setAgility(9);
        int expectedEva = 9*BASE_EVA;
        int expectedSpeed = 9*BASE_SPEED;
        assertEquals(expectedEva, p.getEvasion());
        assertEquals(expectedSpeed, p.getSpeed());
    }

    @Test
    public void testAgilityBaseGrowth2(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setAgility(11);
        p.setStamina(11);
        int expectedEva = 11*BASE_EVA;
        int expectedSpeed = 11*BASE_SPEED;
        assertEquals(expectedEva, p.getEvasion());
        assertEquals(expectedSpeed, p.getSpeed());
    }

    @Test
    public void testAgilityMinGrowth(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStamina(11);
        p.setAgility(9);
        int expectedEva = 9*(BASE_EVA/2);
        int expectedSpeed = 9*(BASE_SPEED/2);
        assertEquals(expectedEva, p.getEvasion());
        assertEquals(expectedSpeed, p.getSpeed());
    }

    @Test
    public void testAgilityMaxGrowth(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStamina(9);
        p.setAgility(11);
        int expectedEva = BASE_EVA*9 + ((BASE_EVA * 2) * (11-9));
        int expectedSpeed = BASE_SPEED*9 + ((BASE_SPEED * 2) * (11-9));
        assertEquals(expectedEva, p.getEvasion());
        assertEquals(expectedSpeed, p.getSpeed());
    }

    @Test
    public void testSetIntelligenceUnder1(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setIntelligence(0);
        });
    }

    @Test
    public void testSetIntelligenceOverMax(){
        PlayerCharacter p = new PlayerCharacter("player");
        assertThrows(IllegalArgumentException.class, () ->{
            p.setIntelligence(101);
        });
    }

    @Test
    public void testIntelligenceBaseGrowth1(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setIntelligence(9);
        int expectedMp= 9*BASE_MP;
        int expectedMdef = 9*BASE_MDEF;
        assertEquals(expectedMp, p.getMana());
        assertEquals(expectedMdef, p.getMagicDef());
    }

    @Test
    public void testIntelligenceBaseGrowth2(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setIntelligence(11);
        p.setStrength(11);
        int expectedMp= 11*BASE_MP;
        int expectedMdef = 11*BASE_MDEF;
        assertEquals(expectedMp, p.getMana());
        assertEquals(expectedMdef, p.getMagicDef());
    }


    @Test
    public void testIntelligenceMaxGrowth(){
        PlayerCharacter p = new PlayerCharacter("player");
        p.setStrength(9);
        p.setIntelligence(11);
        int expectedMp= BASE_MP*9 + ((BASE_MP * 2) * (11-9));
        int expectedMdef = BASE_MDEF*9 + ((BASE_MDEF * 2) * (11-9));
        assertEquals(expectedMp, p.getMana());
        assertEquals(expectedMdef, p.getMagicDef());
    }


}