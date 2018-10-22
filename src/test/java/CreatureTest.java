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
	public void testCreatureSetLife(){
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		Creature monster = new Monster("Monster", 100, 1.0, 1);
		
		player.setLife(150);
		monster.setLife(150);
	}

	@Test
	public void testGetLevel() {
		/*
		 * Testa karaktärens level karaktären börjar på level 1 och attributen
		 * ska inte gå att minska Max level är 10
		 */
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		assertEquals(1, player.getLevel());

	}
	
	@Test
	public void testGetStrength(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		assertEquals(0, player.getStrength());
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
		Creature player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		
		player.damageTaken(10);
		player.damageTaken(10);
		assertEquals(80, player.getLife());
		
		for (int i = 8; i != 0; i--) {
			player.damageTaken(10);
		}
		
		assertEquals(0, player.getLife());
		
		assertThrows(IllegalStateException.class, () -> {
			player.damageTaken(10);
		});
		
	}
	
	@Test
	public void testPlayerCharacterDmgDealt(){
		PlayerCharacter player = new PlayerCharacter("JohnDoe", 100, 1.0, 1);
		assertEquals(5, player.damageDealt());
		
		player.buffStrength();
		assertEquals(10, player.damageDealt());
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
		PlayerCharacter player = new PlayerCharacter("Monster", 100, 1.0, 1);
		player.buffStrength();
		
		assertEquals(2, player.getStrength());
		
	}
	
	@Test
	public void testPlayerLifeAfterBuff(){
		PlayerCharacter player = new PlayerCharacter("Monster", 100, 1.0, 1);
		for(int i = 0; i < 5; i++)
			player.buffStamina();
		
		assertEquals(150, player.getLife());
	}

}
