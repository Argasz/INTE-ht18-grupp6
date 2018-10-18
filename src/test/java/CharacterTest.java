import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterTest {
	
	public CharacterTest(){
		
	}

	@Test
	public void testFail() {
		fail("Not yet implemented.");
	}

	public void testNewCharacter(){
		Character c1 = new Character(20, 45);
	}
        
	@Test
	public void testGetLife(){
            // Testa karakt�rens HP - heltal
		Character player = new Character(konstruktor);
		int life = player.getLife();
		assertEquals(life,1);
	}
        
	@Test
	public void testGetSpeed(){
		// Testa karaktärens Hastighet - flyttal
		Character player = New Character(konstruktor);
		float speed = player.getSpeed();
		assertEquals(Speed,1);              
	}
	
	@Test
	public void testLevel(){
		/* Testa karaktärens level
		 * karaktären börjar på level 1 och attributen ska inte gå att minska 
		 * Max level är 10
		 */
	}

}
