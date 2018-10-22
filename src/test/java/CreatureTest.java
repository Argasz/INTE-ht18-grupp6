import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreatureTest {

	@Test
	public void testNewCreature() {
		Creature player = new Creature("JohnDoe", 100, 1.0, 1); // Testa konstruktorn
		Creature playerNameLetter = new Creature("aaaaabbbbbccccc", 100, 1.0, 1);
		Creature playerNameInt = new Creature("111112222233333", 100, 1.0, 1);
		Creature playerNameLetterInt = new Creature("aaaaabbbbb1111122222", 100, 1.0, 1);

		assertThrows(IllegalArgumentException.class, () -> {
			Creature playerNoName = new Creature("", 100, 1.0, 1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			Creature playerNoName = new Creature("aaaaabbbbbcccccddddde", 100, 1.0, 1);
		});
	}

	@Test
	public void testGetLife() {
		// Testa karakt�rens HP - heltal
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);
		assertEquals(100, player.getLife());
	}

	@Test
	public void testGetSpeed() {
		// Testa karaktärens Hastighet - flyttal
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);
		assertEquals(1.0, player.getSpeed());
	}

	@Test
	public void testGetLevel() {
		/*
		 * Testa karaktärens level karaktären börjar på level 1 och attributen
		 * ska inte gå att minska Max level är 10
		 */
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);
		assertEquals(1, player.getLevel());

	}

	@Test
	public void testGainLevel() {
		// Karaktären kan bara gå upp 1 lvl i taget
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);

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
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);
		
		player.damageTaken();
		player.damageTaken();
		assertEquals(80, player.getLife());
		
		for (int i = 8; i != 0; i--) {
			player.damageTaken();
		}
		
		assertEquals(0, player.getLife());
		
		assertThrows(IllegalStateException.class, () -> {
			player.damageTaken();
		});
		
	}

}