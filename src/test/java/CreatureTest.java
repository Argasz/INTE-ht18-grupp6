import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreatureTest {

	public void testNewCharacter(){
		Creature player = new Creature("JohnDoe", 100, 1.0, 1); // Testa konstruktorn
	}
        
	@Test
	public void testGetLife(){
            // Testa karakt�rens HP - heltal
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);
		assertEquals(player.getLife(), 100);
	}
        
	@Test
	public void testGetSpeed(){
		// Testa karaktärens Hastighet - flyttal
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);
		assertEquals(player.getSpeed(), 1.0);              
	}
	
	@Test
	public void testGetLevel(){
		/* Testa karaktärens level
		 * karaktären börjar på level 1 och attributen ska inte gå att minska 
		 * Max level är 10
		 */
		Creature player = new Creature("JohnDoe", 100, 1.0, 1);
		assertEquals(player.getLevel(), 1);
		
	}
	
	@Test
	public void testGainLevel(){
		// Karaktären kan bara gå upp 1 lvl i taget
		Creature player = new Creature("JohnDoe", 100, 1.0, 1); // namn, life, speed & level
		assertEquals(player.getLevel(), 1);
		
	}

}
