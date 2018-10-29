import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreatureTest {

	@Test
	public void testNewCreature() {
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1); // Testa konstruktorn
		Creature playerNameLetter = new PlayerCharacter("aaaaabbbbbccccc", 100, 1.0, 1);
		Creature playerNameInt = new PlayerCharacter("111112222233333", 100, 1.0, 1);
		Creature playerNameLetterInt = new PlayerCharacter("aaaaabbbbb1111122222", 100, 1.0, 1);

		assertThrows(IllegalArgumentException.class, () -> {
			Creature playerNoName = new PlayerCharacter("", 100, 1.0, 1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			Creature playerNoName = new PlayerCharacter("aaaaabbbbbcccccddddde", 100, 1.0, 1);
		});
		
		assertEquals(1, ((PlayerCharacter)player).getStamina());
		assertEquals(1, ((PlayerCharacter)player).getStrength());
		assertEquals(1, ((PlayerCharacter)player).getLevel());
		assertEquals(100, ((PlayerCharacter)player).getLife());
		assertEquals(1.0, player.getSpeed());
	}
	
	@Test
	public void testGetName(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		assertEquals("JohnDoe", player.getName());
	}

	@Test
	public void testGetLife() {
		// Testa karakt�rens HP - heltal
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		assertEquals(100, player.getLife());
	}

	@Test
	public void testGetSpeed() {
		// Testa karaktärens Hastighet - flyttal
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		assertEquals(1.0, player.getSpeed());
	}
	
	@Test
	public void testGetAgility(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		assertEquals(1, player.getAgility());
	}
	
	@Test
	public void testGetDodge(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		assertEquals(1, player.getDodgeRating());
		
		player.increaseLevel();
		player.increaseLevel();
		assertEquals(3, player.getDodgeRating());
	}
	
	@Test
	public void testCreatureSetLife(){
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		Creature monster = new Monster("Monster", 100, 1.0, 1);
		
		player.setLife(150);
		monster.setLife(150);
	}

	@Test
	public void testGetLevel() {
		/*
		 * Testa karaktärens level karaktären börjar på level 1
		 */
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		assertEquals(1, player.getLevel());
		
		player.gainLevel();
		assertEquals(2, player.getLevel());
	}
	
	@Test
	public void testGetStrength(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		assertEquals(1, player.getStrength());
	}
	
	@Test
	public void testGetStamina(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		assertEquals(1, player.getStamina());
		
		player.increaseLevel();
		assertEquals(2, player.getStamina());
	}
	
	@Test
	public void testSetLife(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		player.setLife(110);
		assertEquals(110,player.getLife());
		
		player.damageTaken(10);
		player.increaseLevel();
		assertEquals(110, player.getLife());
		
		assertThrows(IllegalArgumentException.class, () -> {
			player.setLife(501);
		});
	}

	@Test
	public void testGainLevel() {
		// Karaktären kan bara gå upp 1 lvl i taget
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);

		assertEquals(1, player.getLevel());
		player.gainLevel();
		player.gainLevel();

		assertEquals(3, player.getLevel());
		player.gainLevel();
		player.gainLevel();

		assertEquals(5, player.getLevel());
		for (int i = player.getLevel(); i < 11; i++) {
			player.gainLevel();
		}
		assertNotEquals(11, player.getLevel());
		assertEquals(10, player.getLevel());

	}
	
	@Test
	public void testDamageTaken(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		player.damageTaken(10);
		player.damageTaken(10);
		assertEquals(80, player.getLife());
		
		player.increaseLevel();
		
		
		for (int i = 8; i != 0; i--) {
			player.damageTaken(10);
		}
		
		assertEquals(0, player.getLife());
		
		assertThrows(IllegalStateException.class, () -> {
			player.damageTaken(10);
		});
		
	}
	
	@Test  // INTE FÄRDIG, spelaren ska kunna dodge'a dmg beroende på olika stats 
	public void testRecieveDamage(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		player.increaseLevel();
		player.increaseLevel();
		player.increaseLevel();
		
		
	}
	
	@Test
	public void testPlayerCharacterDmgDealt(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		assertEquals(5, player.damageDealt());
		
		player.buffStrength();
		assertEquals(10, player.damageDealt());
		
		player.gainLevel();
		assertEquals(10, player.damageDealt());
		
		player.increaseLevel();
		assertEquals(15, player.damageDealt());
	}
	
	@Test
	public void testMonsterDmgDealt(){
		Creature monster = new Monster("Monster", 100, 1.0, 1);
		assertEquals(10, monster.damageDealt());
	}
	
	@Test
	public void testBuffStamina(){
		PlayerCharacter player = new PlayerCharacter("Monster", 100, 1.0, 1);
		player.buffStamina();
		
		assertEquals(110, player.getLife());
		assertNotEquals(120, player.getLife());
	}
	
	@Test
	public void testBuffStrength(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		player.buffStrength();
		
		assertEquals(2, player.getStrength());
		
	}
	
	@Test
	public void testBuffDodge(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		player.buffDodgeRating();
		player.buffDodgeRating();
		assertEquals(3, player.getDodgeRating());
		
		player.increaseLevel();
		player.increaseLevel();
		assertEquals(5, player.getDodgeRating());
	}
	
	@Test
	public void testPlayerLifeAfterBuff(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		for(int i = 0; i < 5; i++)
			player.buffStamina();
		
		assertEquals(150, player.getLife());
	}
	
	@Test
	public void testPlayerStatsAfterLvlUp(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		 
		player.increaseLevel();
		assertEquals(2, player.getLevel());
		assertEquals(2, player.getStamina());
		assertEquals(2, player.getStrength());
		assertEquals(110, player.getLife());
		
		
		
	}

}
