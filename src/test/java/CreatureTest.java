import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreatureTest {


	public void testNewValidCharacter(){
		Creature c1 = new Creature(20, 45);
	}
        
	@Test
	public void testGetLife(){

            // Testa karakt�rens HP - heltal
            Creature player = new Creature(1,10);
		int life = player.getLife();
                assertEquals(life,1);

	}
        
        
	@Test
	public void testGetSpeedTest(){
	//Testa karaktärens Hastighet - flyttal
            Creature player = new Creature(10,1);
            float speed = player.getSpeed();
            assertEquals(speed,1f);
                        
                        
                        
                
	}

}
