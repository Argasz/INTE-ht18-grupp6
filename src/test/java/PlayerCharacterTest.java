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
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStrength(10);
        assertEquals(10,p.getStrength());
    }
    @Test
    public void testSetValidStamina(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStamina(10);
        assertEquals(10,p.getStamina());
    }

    @Test
    public void testSetValidAgility(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setAgility(10);
        assertEquals(10,p.getAgility());
    }

    @Test
    public void testSetValidIntelligence(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setIntelligence(10);
        assertEquals(10,p.getIntelligence());
    }

    @Test
    public void testSetStrengthUnder1(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        assertThrows(IllegalArgumentException.class, () ->{
            p.setStrength(0);
        });
    }

    @Test
    public void testSetStrengthOverMax(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        assertThrows(IllegalArgumentException.class, () ->{
            p.setStrength(101);
        });
    }

    @Test
    public void testStrengthBaseGrowth(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStrength(9);
        p.setIntelligence(9);
        assertEquals(BASE_AP * 9, p.getAttackPower());
        assertEquals(BASE_PHYSDEF * 9, p.getPhysDef());
    }

    @Test
    public void testStrengthMinGrowth(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStrength(9);
        p.setIntelligence(11);
        assertEquals( 9, p.getAttackPower());
        int expectedPhysdef = 9*(BASE_PHYSDEF/2);
        assertEquals( expectedPhysdef, p.getPhysDef());
    }

    @Test
    public void testStrengthMaxGrowth(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStrength(12);
        p.setIntelligence(9);
        int expectedAP = BASE_AP*9 + ((BASE_AP * 2) * (12-9));
        int expectedPdef = BASE_PHYSDEF*9 + ((BASE_PHYSDEF * 2) * (12-9));
        assertEquals(expectedAP, p.getAttackPower());
        assertEquals(expectedPdef, p.getPhysDef());
    }

    @Test
    public void testStaminaBaseGrowth(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStamina(9);
        assertEquals(BASE_HP * 9, p.getLife());
        assertEquals(BASE_CARRY * 9, p.getCarryWeight());
    }

    @Test
    public void testStaminaMinGrowth(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStamina(9);
        p.setAgility(11);
        int expectedLife= 9*(BASE_HP/2);
        assertEquals( expectedLife, p.getLife());
        int expectedCarry = 9*(BASE_CARRY/2);
        assertEquals( expectedCarry, p.getCarryWeight());
    }

    @Test
    public void testStaminaMaxGrowth(){
        PlayerCharacter p = new PlayerCharacter("player", 100, 5, 1);
        p.setStamina(12);
        int expectedLife = BASE_HP*9 + ((BASE_HP * 2) * (12-9));
        int expectedCarry = BASE_CARRY*9 + ((BASE_CARRY * 2) * (12-9));
        assertEquals(expectedLife, p.getLife());
        assertEquals(expectedCarry, p.getCarryWeight());
    }



}