import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DungeonGenTreeTest {

    DungeonGenTree<Integer> dgt = new DungeonGenTree<>();

    @BeforeEach
    public void setUp(){
        dgt.clear();
        dgt.add(1);
        dgt.add(2);
        dgt.add(3);
        dgt.add(4);
        dgt.add(5);
        dgt.add(6);
        dgt.add(7);
    }


    @Test
    public void testEmpty(){
        dgt.clear();
        assertEquals(0, dgt.size());
    }

    @Test
    public void testAddValidUnique(){
        assertTrue(dgt.add(8));
        assertTrue(dgt.contains(8));
    }


}