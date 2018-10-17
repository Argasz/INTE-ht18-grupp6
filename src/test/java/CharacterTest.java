import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterTest {

	@Test
	public void testFail() {
		fail("Not yet implemented.");
	}

	public void testNewCharacter(){
	}
        
	@Test
	public void testGetLife(){
            // Testa karakt‰rens HP - heltal
            Character player = new Character(konstruktor);
		int life = player.getLife();
                assertEquals(life,1);
	}
        
        
	@Test
	public void testGetSpeedTest(){
		// Testa karakt√§rens Hastighet - flyttal
                Character player = New Character(konstruktor);
                float speed = player.getSpeed();
                assertEquals(Speed,1);     
                        
                        
                        
                
	}

}
