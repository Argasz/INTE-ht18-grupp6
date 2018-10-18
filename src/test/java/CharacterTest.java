import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterTest {

	public void testNewCharacter(){
		Character character = new Character("JohnDoe", 100, 1.0, 1); // Testa konstruktorn
	}
        
	@Test
	public void testGetLife(){
            // Testa karakt�rens HP - heltal
		Character player = new Character("JohnDoe", 100, 1.0, 1);
		int life = player.getLife();
		assertEquals(life,1);
	}
        
	@Test
	public void testGetSpeed(){
		// Testa karaktärens Hastighet - flyttal
		Character player = new Character("JohnDoe", 100, 1.0, 1);
		float speed = player.getSpeed();
		assertEquals(Speed,1);              
	}
	
	@Test
	public void testGetLevel(){
		/* Testa karaktärens level
		 * karaktären börjar på level 1 och attributen ska inte gå att minska 
		 * Max level är 10
		 */
		Character player = New Character(JohnDoe, 100, 1.0, 1);
		assertEquals(player.getLevel(), 1);
		
	}
	
	@Test
	public void testGainLevel(){
		// Karaktären kan bara gå upp 1 lvl i taget
		Character player = New Character(JohnDoe, 100, 1.0, 1); // namn, life, speed & level
		assertEquals(player.gainLevel(), 2);
		
	}

}
