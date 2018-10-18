import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterTest {


	public void testNewValidCharacter(){
		Character c1 = new Character(20, 45);
	}
        
	@Test
	public void testGetLife(){

            // Testa karakt�rens HP - heltal
            Character player = new Character(1,10);
		int life = player.getLife();
                assertEquals(life,1);

	}
        
        
	@Test
	public void testGetSpeedTest(){
	//Testa karaktärens Hastighet - flyttal
            Character player = new Character(10,1);
            float speed = player.getSpeed();
            assertEquals(speed,1f);
                        
                        
                        
                
	}

}
