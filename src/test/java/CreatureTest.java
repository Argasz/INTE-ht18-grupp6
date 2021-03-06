import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreatureTest {

	@Test
	public void testNewCreature() {
		Creature player = new PlayerCharacter("JohnDoe"); // Testa konstruktorn
		Creature playerNameLetter = new PlayerCharacter("aaaaabbbbbccccc");
		Creature playerNameInt = new PlayerCharacter("111112222233333");
		Creature playerNameLetterInt = new PlayerCharacter("aaaaabbbbb1111122222");

		assertThrows(IllegalArgumentException.class, () -> {
			Creature playerNoName = new PlayerCharacter("");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			Creature playerNoName = new PlayerCharacter("aaaaabbbbbcccccddddde");
		});
		
		assertEquals(1, ((PlayerCharacter)player).getStamina());
		assertEquals(1, ((PlayerCharacter)player).getStrength());
		assertEquals(1, ((PlayerCharacter)player).getLevel());
		assertEquals(6, ((PlayerCharacter)player).getLife());
		assertEquals(4, player.getSpeed());
	}
	
	@Test
	public void testGetName(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		assertEquals("JohnDoe", player.getName());
	}

	@Test
	public void testGetLife() {
		// Testa karakt�rens HP - heltal
		Creature player = new PlayerCharacter("JohnDoe");
		assertEquals(6, player.getLife());
	}

	@Test
	public void testGetSpeed() {
		// Testa karaktärens Hastighet - flyttal
		Creature player = new PlayerCharacter("JohnDoe");
		assertEquals(4, player.getSpeed());
	}
	
	@Test
	public void testGetAgility(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		assertEquals(1, player.getAgility());
	}
	
	@Test
	public void testGetDodge(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		assertEquals(4, player.getEvasion());
		player.setAgility(2);
		assertEquals(8, player.getEvasion());
	}
	
	@Test
	public void testCreatureSetLife(){
		Creature player = new PlayerCharacter("JohnDoe");
		Creature monster = new Monster("Monster", 100, 1, 1);
		
		player.setLife(150);
		monster.setLife(150);
	}

	@Test
	public void testGetLevel() {
		/*
		 * Testa karaktärens level karaktären börjar på level 1
		 */
		Creature player = new PlayerCharacter("JohnDoe");
		assertEquals(1, player.getLevel());
		
		player.gainLevel();
		assertEquals(2, player.getLevel());
	}
	
	@Test
	public void testGetStrength(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		assertEquals(1, player.getStrength());
		player.setStrength(2);
		assertEquals(2, player.getStrength());
	}
	
	@Test
	public void testGetStamina(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		assertEquals(1, player.getStamina());
		
		player.setStamina(2);
		assertEquals(2, player.getStamina());
	}
	
	@Test
	public void testSetLife(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		player.setLife(110);
		assertEquals(110,player.getLife());
		
		player.damageTaken(10);
		assertEquals(100, player.getLife());
		
		assertThrows(IllegalArgumentException.class, () -> {
			player.setLife(501);
		});
	}

	@Test
	public void testGainLevel() {
		// Karaktären kan bara gå upp 1 lvl i taget
		PlayerCharacter player = new PlayerCharacter("JohnDoe");

		assertEquals(1, player.getLevel());
		player.gainLevel();
		player.gainLevel();

		assertEquals(3, player.getLevel());
		player.gainLevel();
		player.gainLevel();

		assertEquals(5, player.getLevel());
		for (int i = player.getLevel(); i < 50; i++) {
			player.increaseLevel();
		}
		assertThrows(IllegalStateException.class, () ->{
			player.increaseLevel();
		});
		assertNotEquals(51, player.getLevel());
		assertEquals(50, player.getLevel());

	}
	
	@Test
	public void testDamageTaken(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		player.damageTaken(1);
		assertEquals(5, player.getLife());

		player.damageTaken(4);
		assertEquals(1, player.getLife());

		player.damageTaken(2);

		assertEquals(0, player.getLife());
		
	}
	
	@Test  // INTE FÄRDIG, spelaren ska kunna dodge'a dmg beroende på olika stats 
	public void testRecieveDamage(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		
		player.increaseLevel();
		player.increaseLevel();
		player.increaseLevel();
		
		
	}
	
	@Test
	public void testPlayerCharacterDmgDealt(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe");
		assertEquals(5, player.damageDealt());

		player.setStrength(2);
		assertEquals(10, player.damageDealt());
		
		player.increaseLevel();
		assertEquals(15, player.damageDealt());
	}
	
	@Test
	public void testMonsterDmgDealt(){
		Creature monster = new Monster("Monster", 100, 1, 1);
		assertEquals(10, monster.damageDealt());
	}


}
